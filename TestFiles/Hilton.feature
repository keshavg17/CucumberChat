Feature: Sanity Check for Hilton Service chat
		 Accept the chat and perform the interactive chat

   Scenario: Hilton Service Chat
   Given I use chrome1 browser
   Given Agent is available to take chat
   Given I open Hilton Service
   When during office hours
   Then Chat Invite is accepted
   Then Submit the PCF
   Then I enter "Hello Test message from Visitor" in textbox
   Then Agent Sends a message
   Then End the chat from Visitor
   Then Submit the Exit Survey And "Thank you for your feedback" message should be displayed
   Then Close the chat window
