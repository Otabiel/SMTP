import config.ConfigurationManager;
import model.prank.Prank;
import model.prank.PrankGenerator;
import smtp.SmtpClient;

import java.io.IOException;
import java.util.List;

public class MailRobot {

    public static void main(String[] args) {
        ConfigurationManager configurationManager = null;
        try {
            configurationManager = new ConfigurationManager();
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
            ioException.printStackTrace();
        }
        String address = configurationManager.getSmtpServerAddress();
        int port = configurationManager.getSmtpServerPort();
        SmtpClient smtpClient = new SmtpClient(address, port);

        try {
            PrankGenerator pg = new PrankGenerator(configurationManager);
            List<Prank> pranks = pg.generatePranks();

            for (Prank p : pranks) {
                smtpClient.sendMessage(p.generateMailMessage());
            }
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
            ioException.printStackTrace();
        }
    }

}
