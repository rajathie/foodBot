package foodBot;
// other classes are being used and imported
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

// starting point class
public class FoodBot {
    // starting method (by default). Argument String array: not being used
    public static void main(String[] args) {
        // Initialization of Telegram application programming interface  
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            // Creation of my new foodbot object and pass to telegram API
            OrderBot myOrderBot = new OrderBot();
            botsApi.registerBot(myOrderBot);
            botsApi.registerBot(new AdminBot(myOrderBot));
            System.out.println("FoodBot is ready to use!");
        } catch (TelegramApiException e) {
            // catch = in case of exception show error message 
            e.printStackTrace();
        }
    }
}