package com.pravin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.bind.DatatypeConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pravin.nessa.model.LeadUtm;

/**
 * 
 * @author Pravin C
 *
 */
public class ServiceCaller {
	
	private static final String userName = "pravin-webapi";
	private static final String password = "4MgH_g>dKeqE[y*\\";
	
	private static final String clientId = "pravin-webapi";
	private static final String clientSecret = "4MgH_g>dKeqE[y*\\";
	
	private static final String BASE_URL = "https://noice-staging.nessa.club/rest/v2";
	private static final String API = "/oauth/token";
	private static final String LEAD_UTM = "/services/crm_CustomerService/addNewLeadUtm";
	
	public String getAccessToken() {
		String encodedData = null;
		try {
			encodedData = DatatypeConverter.printBase64Binary((clientId + ":" + clientSecret).getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		encodedData = "Y2xpZW50OnNlY3JldA==";
		
	    String content = "grant_type=password&username=" + userName + "&password=" + password;
	    BufferedReader reader = null;
	    HttpsURLConnection connection = null;
	    String returnValue = "";
	    try {
	        URL url = new URL(BASE_URL+API);
	        connection = (HttpsURLConnection) url.openConnection();
	        connection.setRequestMethod("POST");
	        connection.setDoOutput(true);
	        connection.setRequestProperty("Authorization", "Basic "+encodedData);
	        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        connection.setRequestProperty("Accept", "application/json");
	        PrintStream os = new PrintStream(connection.getOutputStream());
	        os.print(content);
	        os.close();
	        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String line = null;
	        StringWriter out = new StringWriter(connection.getContentLength() > 0 ? connection.getContentLength() : 2048);
	        while ((line = reader.readLine()) != null) {
	            out.append(line);
	        }
	        String response = out.toString();
	        returnValue = response;
	    } catch (Exception e) {
	        System.out.println("Error : " + e.getMessage());
	    } finally {
	        if (reader != null) {
	            try {
	                reader.close();
	            } catch (IOException e) {
	            }
	        }
	        connection.disconnect();
	    }
	    return returnValue;
	}

	public String addLeadUtm(LeadUtm leadUtm, String token) {
		HttpsURLConnection connection = null;
		BufferedReader reader = null;
		String response = "";
		try {
			URL url = new URL(BASE_URL+LEAD_UTM);
			connection = (HttpsURLConnection) url.openConnection();
	        connection.setRequestMethod("POST");
	        connection.setDoOutput(true);
	        connection.setRequestProperty("Authorization", "Bearer "+token);
	        connection.setRequestProperty("Content-Type", "application/json");
	        connection.setRequestProperty("Accept", "application/json");
	        PrintStream os = new PrintStream(connection.getOutputStream());
	        ObjectMapper mapper = new ObjectMapper();
	        os.print(mapper.writeValueAsString(leadUtm));
	        os.close();
	        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String line = null;
	        StringWriter out = new StringWriter(connection.getContentLength() > 0 ? connection.getContentLength() : 2048);
	        while ((line = reader.readLine()) != null) {
	            out.append(line);
	        }
	        response = out.toString();
		} catch (IOException e) {
			response = "{\"success\": false, \"message\":\"Due to error at End point, unable to save, Possibly Conditional mandatory fields are not handled properly for Phone Number and email.\" }";
		}
		return response;
	}

}
