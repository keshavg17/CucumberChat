$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/UDEFeature/features/UDE.feature");
formatter.feature({
  "line": 1,
  "name": "SiriusXM AIVA",
  "description": "",
  "id": "siriusxm-aiva",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Prepare ENV for UDE chat",
  "description": "",
  "id": "siriusxm-aiva;prepare-env-for-ude-chat",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I use Chrome browser for Chat",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I launch URL \"http://anvil.tellme.com/~keskumar/ude/#start\"",
  "keyword": "Given "
});
formatter.match({
  "location": "SXMAIVA_Definition.i_use_Chrome_browser_for_Chat()"
});
formatter.result({
  "duration": 6718102386,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "http://anvil.tellme.com/~keskumar/ude/#start",
      "offset": 14
    }
  ],
  "location": "SXMAIVA_Definition.i_launch_URL(String)"
});
formatter.result({
  "duration": 5601090079,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Validate UDE Chat widget UI",
  "description": "",
  "id": "siriusxm-aiva;validate-ude-chat-widget-ui",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "Button Chat is accepted and connected to agent",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "Validate the UI",
  "keyword": "Then "
});
formatter.match({
  "location": "SXMAIVA_Definition.Button_chat_is_accepted_and_connected_to_agent()"
});
formatter.result({
  "duration": 30775524244,
  "status": "passed"
});
formatter.match({
  "location": "SXMAIVA_Definition.validate_the_UI()"
});
formatter.result({
  "duration": 1193772367,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "SXM Cancel_Subscription_to_Transfer to Cancel_Phone_Options No Flow with FeedBack Form",
  "description": "",
  "id": "siriusxm-aiva;sxm-cancel-subscription-to-transfer-to-cancel-phone-options-no-flow-with-feedback-form",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "Validate AIVA Responses \"Hi, I\u0027m the Sirius XM Virtual Agent. I\u0027m here for you!\"",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "Validate AIVA Responses \"May I have your first and last name?\"",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "User message is sent successfully \".Keshav Kumar\"",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "Validate AIVA Responses \"Thanks, may I also have your phone number, including your area code?\"",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "User message is sent successfully \".9964202472\"",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "Validate AIVA Responses \"Thanks, again.\"",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "Validate AIVA Responses \"How can I help you?\"",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "User message is sent successfully \".I want to cancel my subscription\"",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "Validate AIVA Responses \"Okay, I may be able to help you with that.\"",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "Validate AIVA Responses \"May I ask why you wish to cancel your subscription?\"",
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "User message is sent successfully \".TestMessageabc\"",
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "Validate AIVA Responses \"Chat specialists cannot cancel subscriptions. To cancel your subscription, you must call 888-601-6302.\"",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "Validate AIVA Responses \"Is there anything else you wish to chat about today?\"",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "Select Quick Response \"No\"",
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "Validate AIVA Responses \"Did that help?\"",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "Select Quick Response \"No\"",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "Submit the FeedBack Form",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "Validate AIVA Responses \"Thanks, again.\"",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "Validate the AIVA responses \"SXM Cancel_Subscription_to_Transfer to Cancel_Phone_Options No Flow with FeedBack Form\"",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "Reinitiate the chat window for other scenario",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Hi, I\u0027m the Sirius XM Virtual Agent. I\u0027m here for you!",
      "offset": 25
    }
  ],
  "location": "SXMAIVA_Definition.Validate_AIVA_Responses(String)"
});
formatter.result({
  "duration": 8096687131,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "May I have your first and last name?",
      "offset": 25
    }
  ],
  "location": "SXMAIVA_Definition.Validate_AIVA_Responses(String)"
});
formatter.result({
  "duration": 8031760534,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": ".Keshav Kumar",
      "offset": 35
    }
  ],
  "location": "SXMAIVA_Definition.user_message_is_sent_successfully(String)"
});
formatter.result({
  "duration": 9374608639,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Thanks, may I also have your phone number, including your area code?",
      "offset": 25
    }
  ],
  "location": "SXMAIVA_Definition.Validate_AIVA_Responses(String)"
});
