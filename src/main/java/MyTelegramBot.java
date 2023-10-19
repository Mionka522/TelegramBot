import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyTelegramBot extends TelegramLongPollingBot {
    private final String BOT_NAME;
    private final String BOT_TOKEN;
    private final String URL = "https://api.nasa.gov/planetary/apod?api_key=pSL3XZoHLxMvKM72ua5apboEeWRmBpWVJQXwbEdv";


    public MyTelegramBot(String BOT_NAME, String BOT_TOKEN) throws TelegramApiException {
        this.BOT_NAME = BOT_NAME;
        this.BOT_TOKEN = BOT_TOKEN;

        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(this);

    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String[] sepAnswer_ = update.getMessage().getText().split(" ");
            String answer = sepAnswer_[0];
            long chatID = update.getMessage().getChatId();

            switch (answer) {
                case "/help":
                    sendMessage("Для картинки дня NASA введи: /start", chatID);
                    break;
                case "/start":
                    String url = Utils.getURL(URL);
                    String date =  Utils.getDATE(URL);

                    sendMessage("Картинка дня на "+ date + ":" + url, chatID);
                    break;
               
                default:
                    sendMessage("Я не понимаю твоей команды", chatID);
                    break;
            }
        }
    }

    private void sendMessage(String msg,long chatID) {
        SendMessage message = new SendMessage();
        message.setText(msg);
        message.setChatId(chatID);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            System.out.println("не смогу отправить сообщение");
        }
    }
    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}
