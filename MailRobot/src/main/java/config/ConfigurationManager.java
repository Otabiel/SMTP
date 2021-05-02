package config;

import model.mail.Person;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class ConfigurationManager {

    private String smtpServerAddress;
    private int smtpServerPort;
    private final List<Person> victims;
    private final List<String> messages;
    private int numberOfGroups;
    private List<Person> witnessesToCC;

    public ConfigurationManager() throws IOException {
        victims = loadAdressesFromFile("./config/victimes.utf8");
        messages = loadMessagesFromFile("./config/messages.utf8");
        loadProperties("./config/config.properties");
    }

    private void loadProperties(String fileName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        Properties properties = new Properties();
        properties.load(fis);
        smtpServerAddress = properties.getProperty("smtpServerAdress");
        smtpServerPort = Integer.parseInt(properties.getProperty("smtpServerPort"));
        numberOfGroups = Integer.parseInt(properties.getProperty("numberOfGroups"));
        witnessesToCC = new ArrayList<>();
        String witnesses = properties.getProperty("witnessesToCC");
        String[] witnessesAdresses = witnesses.split(",");
        for (String address : witnessesAdresses) {
            witnessesToCC.add(new Person(address));
        }
    }

    private List<Person> loadAdressesFromFile(String filename) throws IOException {
        List<Person> result;
        try (FileInputStream fis = new FileInputStream(filename)) {
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            try (BufferedReader reader = new BufferedReader(isr)) {
                result = new ArrayList<>();
                String address = reader.readLine();
                while (address != null) {
                    result.add(new Person(address));
                    address = reader.readLine();
                }
            }
        }
        return result;
    }

    private List<String> loadMessagesFromFile(String fileName) throws IOException {
        List<String> result;
        try (FileInputStream fis = new FileInputStream(fileName)) {
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            try (BufferedReader reader = new BufferedReader(isr)){
                result = new ArrayList<>();
                String line = reader.readLine();
                while (line != null) {
                    StringBuilder body = new StringBuilder();
                    while ((line != null) && (!line.equals("___"))) {
                        body.append(line);
                        body.append("\r\n");
                        line = reader.readLine();
                    }
                    result.add(body.toString());
                    line = reader.readLine();
                }
            }
        }
        return result;
    }

    public List<Person> getVictims() {
        return victims;
    }

    public List<String> getMessages() {
        return messages;
    }

    public List<Person> getWitnessesToCC() {
        return witnessesToCC;
    }

    public int getNumberOfGroups() {
        return numberOfGroups;
    }

    public int getSmtpServerPort() {
        return smtpServerPort;
    }

    public String getSmtpServerAddress() {
        return smtpServerAddress;
    }
}


