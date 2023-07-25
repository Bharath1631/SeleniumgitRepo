package resources;

import java.io.File;
//import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Base 
{
	//public static Logger log =LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	public static String localDir = System.getProperty("user.dir");
	public static String home = System.getProperty("user.home");
	public static String DownloadsPath = home+"/Downloads";
	List<String> filesListInDir = new ArrayList<String>();
	
	static LocalDateTime dateTime = LocalDateTime.now();  
	//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
	public static String date = DateTimeFormatter.ofPattern("dd").format(dateTime);
	public static String month = DateTimeFormatter.ofPattern("MM").format(dateTime);
	public static String year = DateTimeFormatter.ofPattern("YYYY").format(dateTime);
	public static String hour = DateTimeFormatter.ofPattern("HH").format(dateTime);
	public static String minute = DateTimeFormatter.ofPattern("mm").format(dateTime);
	public static String second = DateTimeFormatter.ofPattern("ss").format(dateTime);   
	
	private static Cipher cipher; 
	private static  SecretKey secretKey = null;
	private static String cipherSecretKey;
	
	public void initSecretKey() throws IOException {

		/*
        Cipher Info
        Algorithm : for the encryption of electronic data
        mode of operation : to avoid repeated blocks encrypt to the same values.
        padding: ensuring messages are the proper length necessary for certain ciphers 
        mode/padding are not used with stream cyphers.  
		 */
		cipherSecretKey = readProperties("cipher.secretkey");
		try {
			
			
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128); // block size is 128bits
			secretKey = new SecretKeySpec(cipherSecretKey.getBytes(), "AES");

			//with this secret key encrypted text never changes.
			//with randomly generated secret key, encrypted text change.So cannot decrypt using random key.
			cipher = Cipher.getInstance("AES"); //SunJCE provider AES algorithm, mode(optional) and padding schema(optional)  


		} catch (NoSuchAlgorithmException e) {
			
		}catch (Exception e) {
			
		}

	}
	
	
	
	
	/* Driver Initialize*/
	public WebDriver driverInitialize(String value) throws IOException {
		
		
		String mode = readProperties("Mode");
		//String value = readProperties("Browser");
		Log.info("Fetching the Browser value as "+value);
		if(value.equals("chrome")){
			
			Log.info("Invoking the "+value+" Browser");
			WebDriverManager.chromedriver().setup();
			
			if(mode.equals("headless")) {
				
				//To Run in Headless Mode
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
				driver = new ChromeDriver(options);
			
			}	
			else {
				
				//To Run in Head Mode
				//driver = new ChromeDriver();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--no-sandbox","--disable-dev-shm-usage");
				driver = new ChromeDriver(options);
				
			}
		}
		
		else if (value.equals("firefox")) {
			
			Log.info("Invoking the "+value+" Browser");
			WebDriverManager.firefoxdriver().setup();
			
			if(mode.equals("headless")) {
				
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				driver = new FirefoxDriver(options);
			
				
//						opts.add_argument("--headless")
//						browser = webdriver.Firefox(options=opts)
			}
			else {
				driver = new FirefoxDriver();
			}
		}
		driver.manage().window().maximize();
		Log.info("Maximized the Browser window");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	
	/* Read Key values from the Property file*/
	public String readProperties(String key) throws IOException {

		Properties property = new Properties();
		//FileInputStream fis = new FileInputStream("/home/anilkumars/git/repository/developers/src/main/java/resources/data.properties");
		FileInputStream fis = new FileInputStream(localDir+"/src/main/java/resources/data.properties");
		property.load(fis);
		Log.info("Reading the Property file");
		String value = property.getProperty(key);
		Log.info("The Value of the "+key+" Fetched from the Properties: "+value);
		return value;
	}
	
  
	
	/* Read Json file and store as Hashmap in List*/
	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException
	
	{
		//read json to string
		String jsonContent = FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
		Log.info("Reading JSON to String");
		//Sting to HashMap
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data =  mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String >>>(){});
		Log.info("Converting String to HashMap");
		return data;
	}
	
	
	
	/* Taking the Screenshot*/
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		Log.info("Taking Screeshot of the webpage");
		File source= ts.getScreenshotAs(OutputType.FILE);	
		//File file=new File(localDir+"/reports/"+testCaseName+".png");
		File file=new File("./reports/Screenshots/"+testCaseName+".png");
		Log.info("Adding the Screenshot to the Reports");
		FileUtils.copyFile(source, file);
		//return localDir+"/reports/"+testCaseName+".png";
		return "./Screenshots/"+testCaseName+".png";
	}
	
	
	//Getting Database Connection
	public Connection getDBconnection(String url, String user, String password) throws InstantiationException, IllegalAccessException, IOException {
		String driver = "com.mysql.cj.jdbc.Driver";
		Connection dbConnection =null;
		
		try {
			
			Class.forName(driver);
			Log.info("Instance created");
			dbConnection = DriverManager.getConnection(url, user, password);
			Log.info("checking database connection");
			if (dbConnection!=null)
				Log.info("----------Database conection successfull----------");
			else
			Log.info("-----------Database connection Failed---------");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return dbConnection;
	
	
	}
	
	//Generate Token for Developer portal EMail Verify
//	public String getToken(int iD) {
//    	
//		Date lastUpdate = new Date();
//    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		String uac = dateFormat.format(lastUpdate) + "_" + iD;
//		String key = Base64.getUrlEncoder().encodeToString(uac.getBytes());
//		return key;
//    	
//    	
//    }
//	
	//Generate Token for Developer portal EMail Verify
public static String encryptString(String plainString) throws Exception {
    	
    	try {
    		
            byte[] plainStringByte = plainString.getBytes();
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedByte = cipher.doFinal(plainStringByte);
            String encryptedString =  Base64.getUrlEncoder().encodeToString(encryptedByte);
           

            return encryptedString;
    	} catch(InvalidKeyException e) {
    		throw e;
    	} catch (IllegalBlockSizeException e) {
            throw e;
        } catch (BadPaddingException e) {
            throw e;
        }
    }
	
	
	
//Generate Token for Developer portal EMail Verify
	public String getToken(int iD) throws Exception {
		
		Date lastUpdate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String uac = dateFormat.format(lastUpdate) + "_" + iD;
//		String key = Base64.getUrlEncoder().encodeToString(uac.getBytes());
		initSecretKey();
		String key = encryptString(uac);
		return key;
		//String verificationUrl = partnerClientUrl+"/set-password?token="+key;
		
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("verification_url", verificationUrl);
//
//		String emailSubject = "Dotgo Developers: Email Verification";
//		mailSenderService.sendPartnersVerificationEmail(profile.getEmail(), emailSubject, model);
		
	}
	
	// To Encrypt the Integer
	public  String encryptID(Integer plainText)  throws Exception  {
		
		try {
			initSecretKey();
			byte[] plainTextByte = BigInteger.valueOf(plainText).toByteArray();
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] encryptedByte = cipher.doFinal(plainTextByte);
			String encryptedText =  Base64.getUrlEncoder().encodeToString(encryptedByte);
			

			return encryptedText;
		} catch (InvalidKeyException e) {
			throw e;
		} catch (IllegalBlockSizeException e) {
			throw e;
		} catch (BadPaddingException e) {
			throw e;
		}
	}
	
	
	
	
	//To Generate Random String for New EMail Signup Everytime we run
	protected String getSaltString(int i, String alpha) {
        String SALTCHARS = alpha;
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < i) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	
	 public  void zipDirectory(File dir, String zipDirName) {
	        try {
	            populateFilesList(dir);
	            //now ZIP files one by one
	            //create ZipOutputStream to write to the ZIP file
	            FileOutputStream fos = new FileOutputStream(zipDirName);
	            ZipOutputStream zos = new ZipOutputStream(fos);
	         
	            for(String filePath : filesListInDir){
	                //For ZipEntry we need to keep only relative file path, so we used substring on absolute path
	                ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length()+1, filePath.length()));
	                zos.putNextEntry(ze);
	                //Read the file and write to ZipOutputStream
	                FileInputStream fis = new FileInputStream(filePath);
	                byte[] buffer = new byte[1024];
	                int len;
	                while ((len = fis.read(buffer)) > 0) {
	                    zos.write(buffer, 0, len);
	                }
	             
	                zos.closeEntry();
	                fis.close();
	            }
	            zos.close();
	            fos.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	   
	    //This method populates all the files in a directory to a List
	    public  void populateFilesList(File dir) throws IOException {
	        File[] files = dir.listFiles();
	        for(File file : files){
	            if(file.isFile()) filesListInDir.add(file.getAbsolutePath());
	            else populateFilesList(file);
	        }
	    }

	public WebDriverWait explicitWait(WebDriver driver, int secs) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
		return wait;
		
	}
	
}
