import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SimpleTelegramBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            // Responda com a mensagem recebida
            sendTextMessage(chatId, "Você disse: " + messageText);
        }
    }

    private void sendTextMessage(long chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        // Substitua "SeuBotNome" pelo nome do seu bot no Telegram
        return "Vitinhoo";
    }

    @Override
    public String getBotToken() {
        // Substitua "SeuToken" pelo token do seu bot no Telegram
        return "teste";
    }

    public static void main(String[] args) {
        
        SimpleTelegramBot bot = new SimpleTelegramBot();
        bot.botConnect();
    }

    private void botConnect() {
        
        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            t
            botsApi.registerBot(this);
            System.out.println("Bot está rodando. Pressione Ctrl+C para sair.");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
