package stepdefinition1;

import io.cucumber.java.en.*;
import org.example.*;
import org.junit.Assert;

public class TinderChatSteps {
    private User1 user1;
    private Match1 match1;
    private Chat chat;
    private  ChatManager chatManager;
    public TinderChatSteps() {
        this.chatManager = new ChatManager();
    }


    @Given("^the user has matches$")
    public void user_has_matches() {
        user1 = new User1();
        user1.addMatch(new Match1("User 1"));
        user1.addMatch(new Match1("User 2"));
    }

    @When("the user opens the match list")
    public void user_opens_match_list() {
        MatchList matchList = new MatchList();
        matchList.open();
    }

    @Then("they should see all their matches")
    public void user_sees_all_matches() {
        Assert.assertEquals(2, user1.getMatches().size());
    }

    @Given("the user has a match")
    public void user_has_match() {
        user1 = new User1();
        match1 = new Match1("User 1");
        chat = new Chat(match1);
    }

    @When("the user starts a chat with the match")
    public void user_starts_chat_with_match() {

        if (chatManager != null) {
            chat = chatManager.startChatWithMatch(match1);
        } else {
            System.out.println("Error: chatManager is null.");
        }
    }
    @Then("they should be able to send a message")
    public void user_can_send_message() {
        Assert.assertTrue(chat.sendMessage("Hello!"));
    }

    @Given("the user has a chat with the match")
    public void user_has_chat_with_match() {
        match1 = new Match1("User 1");
        chat = new Chat(match1);
        chat.sendMessage("Hello!");
    }

    @When("the user sends a message")
    public void user_sends_message() {

        if (chat != null) {

            chat.sendMessage("Hello, how are you?");
        } else {

            System.out.println("Error: Chat is not initialized.");
        }
    }

    @Then("the message should appear in the chat")
    public void message_should_appear_in_chat() {
        Assert.assertTrue(chat.hasMessage("Hello!"));
    }

    @Given("the chat contains messages")
    public void chat_contains_messages() {
        chat.sendMessage("Hello!");
    }

    @When("the user deletes a message")
    public void user_deletes_message() {
        chat.deleteMessage("Hello!");
    }

    @Then("the message should be deleted from the chat")
    public void message_should_be_deleted_from_chat() {
        chat.deleteMessage("Hello!");
        Assert.assertFalse(chat.hasMessage("Hello!"));
    }

    @When("the match sends a new message")
    public void match_sends_new_message() {
        chat.receiveMessage("Hi!");
        user1.updateNotification(true);
    }

    @Then("the user should receive a notification for the new message")
    public void user_should_receive_notification_for_new_message() {
        Assert.assertTrue(user1.hasNotification());
    }
}
