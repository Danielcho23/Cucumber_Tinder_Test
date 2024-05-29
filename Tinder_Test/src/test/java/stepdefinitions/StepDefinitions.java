package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.Match;
import org.example.Profile;
import org.example.User;

import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;


public class StepDefinitions {

    private User currentUser;
    private Profile currentProfile;
    private Set<Profile> likedProfiles = new HashSet<>();
    private Set<Match> matches = new HashSet<>();
    private Profile profileA;
    private Profile profileB;

    @Given("the user is logged in the system")
    public void the_user_is_logged_in() {
        currentUser = new User("currentUser");
    }

    @When("the user views a profile")
    public void the_user_views_profile() {
        currentProfile = new Profile("anotherUser");
    }

    @Then("they should see the profile information")
    public void they_should_see_profile_info() {
        assertNotNull(currentProfile);
        assertEquals("anotherUser", currentProfile.getUsername());
    }

    @When("the user likes the profile")
    public void the_user_likes_profile() {
        likedProfiles.add(currentProfile);
    }

    @Then("the profile should be added to the liked profiles list")
    public void profile_added_to_liked_list() {
        assertTrue(likedProfiles.contains(currentProfile));
    }

    @Given("they are viewing a profile")
    public void they_are_viewing_a_profile() {
        currentProfile = new Profile("anotherUser");
    }

    @When("the user dislikes the profile")
    public void the_user_dislikes_profile() {
        likedProfiles.remove(currentProfile);

        System.out.println("Profile disliked by the user");
    }

    @Then("the profile should not be added to the liked profiles list")
    public void profile_not_added_to_liked_list() {
        assertFalse(likedProfiles.contains(currentProfile));
    }

    @Given("user A likes user B")
    public void user_A_likes_user_B() {
        profileA = new Profile("userA");
        profileB = new Profile("userB");

        likedProfiles.add(profileB);
        profileB.likeProfile(currentUser);

        System.out.println("User A likes user B: " + profileA.getUsername() + " likes " + profileB.getUsername());
    }

    @And("user B likes user A")
    public void user_B_likes_user_A() {
        if (profileA == null) {
            profileA = new Profile("userA");
        }
        profileA.likeProfile(currentUser);

        System.out.println("User B likes user A: " + profileB.getUsername() + " likes " + profileA.getUsername());
    }

    @When("a match is created between user A and user B")
    public void a_match_is_created_between_user_A_and_user_B() {
        if (profileA == null || profileB == null) {
            profileA = new Profile("userA");
            profileB = new Profile("userB");
        }
        profileA.likeProfile(new User("userB"));
        profileB.likeProfile(new User("userA"));
        matches.add(new Match(profileA, profileB));

        System.out.println("Match created between user A and user B");
    }

    @Then("there should be a match between user A and user B")
    public void there_should_be_a_match_between_user_A_and_user_B() {
        Match expectedMatch = new Match(profileA, profileB);
        System.out.println("Expected Match: " + expectedMatch.getProfileA().getUsername() + " and " + expectedMatch.getProfileB().getUsername());
        System.out.println("Matches: " + matches);
        assertTrue(matches.contains(expectedMatch));
    }



    @Given("there is a match between user A and user B")
    public void there_is_a_match_between_user_A_and_user_B() {
        profileA = new Profile("userA");
        profileB = new Profile("userB");

        likedProfiles.add(profileB);
        profileB.likeProfile(profileA.getUser());
        likedProfiles.add(profileA);
        profileA.likeProfile(profileB.getUser());
        matches.add(new Match(profileA, profileB));
    }

    @Then("both users should receive a match notification")
    public void both_users_should_receive_match_notification() {
        assertTrue(profileA.getUser().hasNotification());
        assertTrue(profileB.getUser().hasNotification());
    }

}