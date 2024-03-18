package telegram.chickenbot.huydong.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.telegram.telegrambots.meta.api.interfaces.BotApiObject;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.ChatJoinRequest;
import org.telegram.telegrambots.meta.api.objects.ChatMemberUpdated;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.boost.ChatBoostRemoved;
import org.telegram.telegrambots.meta.api.objects.boost.ChatBoostUpdated;
import org.telegram.telegrambots.meta.api.objects.inlinequery.ChosenInlineQuery;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;
import org.telegram.telegrambots.meta.api.objects.payments.PreCheckoutQuery;
import org.telegram.telegrambots.meta.api.objects.payments.ShippingQuery;
import org.telegram.telegrambots.meta.api.objects.polls.Poll;
import org.telegram.telegrambots.meta.api.objects.polls.PollAnswer;
import org.telegram.telegrambots.meta.api.objects.reactions.MessageReactionCountUpdated;
import org.telegram.telegrambots.meta.api.objects.reactions.MessageReactionUpdated;

public class Update implements BotApiObject {
    private static final String UPDATEID_FIELD = "update_id";
    private static final String MESSAGE_FIELD = "message";
    private static final String INLINEQUERY_FIELD = "inline_query";
    private static final String CHOSENINLINEQUERY_FIELD = "chosen_inline_result";
    private static final String CALLBACKQUERY_FIELD = "callback_query";
    private static final String EDITEDMESSAGE_FIELD = "edited_message";
    private static final String CHANNELPOST_FIELD = "channel_post";
    private static final String EDITEDCHANNELPOST_FIELD = "edited_channel_post";
    private static final String SHIPPING_QUERY_FIELD = "shipping_query";
    private static final String PRE_CHECKOUT_QUERY_FIELD = "pre_checkout_query";
    private static final String POLL_FIELD = "poll";
    private static final String POLLANSWER_FIELD = "poll_answer";
    private static final String MYCHATMEMBER_FIELD = "my_chat_member";
    private static final String CHATMEMBER_FIELD = "chat_member";
    private static final String CHATJOINREQUEST_FIELD = "chat_join_request";
    private static final String MESSAGE_REACTION_FIELD = "message_reaction";
    private static final String MESSAGE_REACTION_COUNT_FIELD = "message_reaction_count";
    private static final String CHAT_BOOST_FIELD = "chat_boost";
    private static final String REMOVED_CHAT_BOOST_FIELD = "removed_chat_boost";
    @JsonProperty("update_id")
    private Long updateId;
    @JsonProperty("message")
    private Message message;
    @JsonProperty("inline_query")
    private InlineQuery inlineQuery;
    @JsonProperty("chosen_inline_result")
    private ChosenInlineQuery chosenInlineQuery;
    @JsonProperty("callback_query")
    private CallbackQuery callbackQuery;
    @JsonProperty("edited_message")
    private Message editedMessage;
    @JsonProperty("channel_post")
    private Message channelPost;
    @JsonProperty("edited_channel_post")
    private Message editedChannelPost;
    @JsonProperty("shipping_query")
    private ShippingQuery shippingQuery;
    @JsonProperty("pre_checkout_query")
    private PreCheckoutQuery preCheckoutQuery;
    @JsonProperty("poll")
    private Poll poll;
    @JsonProperty("poll_answer")
    private PollAnswer pollAnswer;
    @JsonProperty("my_chat_member")
    private ChatMemberUpdated myChatMember;
    @JsonProperty("chat_member")
    private ChatMemberUpdated chatMember;
    @JsonProperty("chat_join_request")
    private ChatJoinRequest chatJoinRequest;
    @JsonProperty("message_reaction")
    private MessageReactionUpdated messageReaction;
    @JsonProperty("message_reaction_count")
    private MessageReactionCountUpdated messageReactionCount;
    @JsonProperty("chat_boost")
    private ChatBoostUpdated chatBoost;
    @JsonProperty("removed_chat_boost")
    private ChatBoostRemoved removedChatBoost;

    public boolean hasMessage() {
        return this.message != null;
    }

    public boolean hasInlineQuery() {
        return this.inlineQuery != null;
    }

    public boolean hasChosenInlineQuery() {
        return this.chosenInlineQuery != null;
    }

    public boolean hasCallbackQuery() {
        return this.callbackQuery != null;
    }

    public boolean hasEditedMessage() {
        return this.editedMessage != null;
    }

    public boolean hasChannelPost() {
        return this.channelPost != null;
    }

    public boolean hasEditedChannelPost() {
        return this.editedChannelPost != null;
    }

    public boolean hasShippingQuery() {
        return this.shippingQuery != null;
    }

    public boolean hasPreCheckoutQuery() {
        return this.preCheckoutQuery != null;
    }

    public boolean hasPoll() {
        return this.poll != null;
    }

    public boolean hasPollAnswer() {
        return this.pollAnswer != null;
    }

    public boolean hasMyChatMember() {
        return this.myChatMember != null;
    }

    public boolean hasChatMember() {
        return this.chatMember != null;
    }

    public boolean hasChatJoinRequest() {
        return this.chatJoinRequest != null;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Update)) {
            return false;
        } else {
            Update other = (Update)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label239: {
                    Object this$updateId = this.getUpdateId();
                    Object other$updateId = other.getUpdateId();
                    if (this$updateId == null) {
                        if (other$updateId == null) {
                            break label239;
                        }
                    } else if (this$updateId.equals(other$updateId)) {
                        break label239;
                    }

                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$inlineQuery = this.getInlineQuery();
                Object other$inlineQuery = other.getInlineQuery();
                if (this$inlineQuery == null) {
                    if (other$inlineQuery != null) {
                        return false;
                    }
                } else if (!this$inlineQuery.equals(other$inlineQuery)) {
                    return false;
                }

                label218: {
                    Object this$chosenInlineQuery = this.getChosenInlineQuery();
                    Object other$chosenInlineQuery = other.getChosenInlineQuery();
                    if (this$chosenInlineQuery == null) {
                        if (other$chosenInlineQuery == null) {
                            break label218;
                        }
                    } else if (this$chosenInlineQuery.equals(other$chosenInlineQuery)) {
                        break label218;
                    }

                    return false;
                }

                label211: {
                    Object this$callbackQuery = this.getCallbackQuery();
                    Object other$callbackQuery = other.getCallbackQuery();
                    if (this$callbackQuery == null) {
                        if (other$callbackQuery == null) {
                            break label211;
                        }
                    } else if (this$callbackQuery.equals(other$callbackQuery)) {
                        break label211;
                    }

                    return false;
                }

                Object this$editedMessage = this.getEditedMessage();
                Object other$editedMessage = other.getEditedMessage();
                if (this$editedMessage == null) {
                    if (other$editedMessage != null) {
                        return false;
                    }
                } else if (!this$editedMessage.equals(other$editedMessage)) {
                    return false;
                }

                Object this$channelPost = this.getChannelPost();
                Object other$channelPost = other.getChannelPost();
                if (this$channelPost == null) {
                    if (other$channelPost != null) {
                        return false;
                    }
                } else if (!this$channelPost.equals(other$channelPost)) {
                    return false;
                }

                label190: {
                    Object this$editedChannelPost = this.getEditedChannelPost();
                    Object other$editedChannelPost = other.getEditedChannelPost();
                    if (this$editedChannelPost == null) {
                        if (other$editedChannelPost == null) {
                            break label190;
                        }
                    } else if (this$editedChannelPost.equals(other$editedChannelPost)) {
                        break label190;
                    }

                    return false;
                }

                label183: {
                    Object this$shippingQuery = this.getShippingQuery();
                    Object other$shippingQuery = other.getShippingQuery();
                    if (this$shippingQuery == null) {
                        if (other$shippingQuery == null) {
                            break label183;
                        }
                    } else if (this$shippingQuery.equals(other$shippingQuery)) {
                        break label183;
                    }

                    return false;
                }

                Object this$preCheckoutQuery = this.getPreCheckoutQuery();
                Object other$preCheckoutQuery = other.getPreCheckoutQuery();
                if (this$preCheckoutQuery == null) {
                    if (other$preCheckoutQuery != null) {
                        return false;
                    }
                } else if (!this$preCheckoutQuery.equals(other$preCheckoutQuery)) {
                    return false;
                }

                label169: {
                    Object this$poll = this.getPoll();
                    Object other$poll = other.getPoll();
                    if (this$poll == null) {
                        if (other$poll == null) {
                            break label169;
                        }
                    } else if (this$poll.equals(other$poll)) {
                        break label169;
                    }

                    return false;
                }

                Object this$pollAnswer = this.getPollAnswer();
                Object other$pollAnswer = other.getPollAnswer();
                if (this$pollAnswer == null) {
                    if (other$pollAnswer != null) {
                        return false;
                    }
                } else if (!this$pollAnswer.equals(other$pollAnswer)) {
                    return false;
                }

                label155: {
                    Object this$myChatMember = this.getMyChatMember();
                    Object other$myChatMember = other.getMyChatMember();
                    if (this$myChatMember == null) {
                        if (other$myChatMember == null) {
                            break label155;
                        }
                    } else if (this$myChatMember.equals(other$myChatMember)) {
                        break label155;
                    }

                    return false;
                }

                Object this$chatMember = this.getChatMember();
                Object other$chatMember = other.getChatMember();
                if (this$chatMember == null) {
                    if (other$chatMember != null) {
                        return false;
                    }
                } else if (!this$chatMember.equals(other$chatMember)) {
                    return false;
                }

                Object this$chatJoinRequest = this.getChatJoinRequest();
                Object other$chatJoinRequest = other.getChatJoinRequest();
                if (this$chatJoinRequest == null) {
                    if (other$chatJoinRequest != null) {
                        return false;
                    }
                } else if (!this$chatJoinRequest.equals(other$chatJoinRequest)) {
                    return false;
                }

                label134: {
                    Object this$messageReaction = this.getMessageReaction();
                    Object other$messageReaction = other.getMessageReaction();
                    if (this$messageReaction == null) {
                        if (other$messageReaction == null) {
                            break label134;
                        }
                    } else if (this$messageReaction.equals(other$messageReaction)) {
                        break label134;
                    }

                    return false;
                }

                label127: {
                    Object this$messageReactionCount = this.getMessageReactionCount();
                    Object other$messageReactionCount = other.getMessageReactionCount();
                    if (this$messageReactionCount == null) {
                        if (other$messageReactionCount == null) {
                            break label127;
                        }
                    } else if (this$messageReactionCount.equals(other$messageReactionCount)) {
                        break label127;
                    }

                    return false;
                }

                Object this$chatBoost = this.getChatBoost();
                Object other$chatBoost = other.getChatBoost();
                if (this$chatBoost == null) {
                    if (other$chatBoost != null) {
                        return false;
                    }
                } else if (!this$chatBoost.equals(other$chatBoost)) {
                    return false;
                }

                Object this$removedChatBoost = this.getRemovedChatBoost();
                Object other$removedChatBoost = other.getRemovedChatBoost();
                if (this$removedChatBoost == null) {
                    if (other$removedChatBoost != null) {
                        return false;
                    }
                } else if (!this$removedChatBoost.equals(other$removedChatBoost)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof org.telegram.telegrambots.meta.api.objects.Update;
    }

    public int hashCode() {
        int PRIME = 1;
        int result = 1;
        Object $updateId = this.getUpdateId();
        result = result * 59 + ($updateId == null ? 43 : $updateId.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $inlineQuery = this.getInlineQuery();
        result = result * 59 + ($inlineQuery == null ? 43 : $inlineQuery.hashCode());
        Object $chosenInlineQuery = this.getChosenInlineQuery();
        result = result * 59 + ($chosenInlineQuery == null ? 43 : $chosenInlineQuery.hashCode());
        Object $callbackQuery = this.getCallbackQuery();
        result = result * 59 + ($callbackQuery == null ? 43 : $callbackQuery.hashCode());
        Object $editedMessage = this.getEditedMessage();
        result = result * 59 + ($editedMessage == null ? 43 : $editedMessage.hashCode());
        Object $channelPost = this.getChannelPost();
        result = result * 59 + ($channelPost == null ? 43 : $channelPost.hashCode());
        Object $editedChannelPost = this.getEditedChannelPost();
        result = result * 59 + ($editedChannelPost == null ? 43 : $editedChannelPost.hashCode());
        Object $shippingQuery = this.getShippingQuery();
        result = result * 59 + ($shippingQuery == null ? 43 : $shippingQuery.hashCode());
        Object $preCheckoutQuery = this.getPreCheckoutQuery();
        result = result * 59 + ($preCheckoutQuery == null ? 43 : $preCheckoutQuery.hashCode());
        Object $poll = this.getPoll();
        result = result * 59 + ($poll == null ? 43 : $poll.hashCode());
        Object $pollAnswer = this.getPollAnswer();
        result = result * 59 + ($pollAnswer == null ? 43 : $pollAnswer.hashCode());
        Object $myChatMember = this.getMyChatMember();
        result = result * 59 + ($myChatMember == null ? 43 : $myChatMember.hashCode());
        Object $chatMember = this.getChatMember();
        result = result * 59 + ($chatMember == null ? 43 : $chatMember.hashCode());
        Object $chatJoinRequest = this.getChatJoinRequest();
        result = result * 59 + ($chatJoinRequest == null ? 43 : $chatJoinRequest.hashCode());
        Object $messageReaction = this.getMessageReaction();
        result = result * 59 + ($messageReaction == null ? 43 : $messageReaction.hashCode());
        Object $messageReactionCount = this.getMessageReactionCount();
        result = result * 59 + ($messageReactionCount == null ? 43 : $messageReactionCount.hashCode());
        Object $chatBoost = this.getChatBoost();
        result = result * 59 + ($chatBoost == null ? 43 : $chatBoost.hashCode());
        Object $removedChatBoost = this.getRemovedChatBoost();
        result = result * 59 + ($removedChatBoost == null ? 43 : $removedChatBoost.hashCode());
        return result;
    }

    public Long getUpdateId() {
        return this.updateId;
    }

    public Message getMessage() {
        return this.message;
    }

    public InlineQuery getInlineQuery() {
        return this.inlineQuery;
    }

    public ChosenInlineQuery getChosenInlineQuery() {
        return this.chosenInlineQuery;
    }

    public CallbackQuery getCallbackQuery() {
        return this.callbackQuery;
    }

    public Message getEditedMessage() {
        return this.editedMessage;
    }

    public Message getChannelPost() {
        return this.channelPost;
    }

    public Message getEditedChannelPost() {
        return this.editedChannelPost;
    }

    public ShippingQuery getShippingQuery() {
        return this.shippingQuery;
    }

    public PreCheckoutQuery getPreCheckoutQuery() {
        return this.preCheckoutQuery;
    }

    public Poll getPoll() {
        return this.poll;
    }

    public PollAnswer getPollAnswer() {
        return this.pollAnswer;
    }

    public ChatMemberUpdated getMyChatMember() {
        return this.myChatMember;
    }

    public ChatMemberUpdated getChatMember() {
        return this.chatMember;
    }

    public ChatJoinRequest getChatJoinRequest() {
        return this.chatJoinRequest;
    }

    public MessageReactionUpdated getMessageReaction() {
        return this.messageReaction;
    }

    public MessageReactionCountUpdated getMessageReactionCount() {
        return this.messageReactionCount;
    }

    public ChatBoostUpdated getChatBoost() {
        return this.chatBoost;
    }

    public ChatBoostRemoved getRemovedChatBoost() {
        return this.removedChatBoost;
    }

    @JsonProperty("update_id")
    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    @JsonProperty("message")
    public void setMessage(Message message) {
        this.message = message;
    }

    @JsonProperty("inline_query")
    public void setInlineQuery(InlineQuery inlineQuery) {
        this.inlineQuery = inlineQuery;
    }

    @JsonProperty("chosen_inline_result")
    public void setChosenInlineQuery(ChosenInlineQuery chosenInlineQuery) {
        this.chosenInlineQuery = chosenInlineQuery;
    }

    @JsonProperty("callback_query")
    public void setCallbackQuery(CallbackQuery callbackQuery) {
        this.callbackQuery = callbackQuery;
    }

    @JsonProperty("edited_message")
    public void setEditedMessage(Message editedMessage) {
        this.editedMessage = editedMessage;
    }

    @JsonProperty("channel_post")
    public void setChannelPost(Message channelPost) {
        this.channelPost = channelPost;
    }

    @JsonProperty("edited_channel_post")
    public void setEditedChannelPost(Message editedChannelPost) {
        this.editedChannelPost = editedChannelPost;
    }

    @JsonProperty("shipping_query")
    public void setShippingQuery(ShippingQuery shippingQuery) {
        this.shippingQuery = shippingQuery;
    }

    @JsonProperty("pre_checkout_query")
    public void setPreCheckoutQuery(PreCheckoutQuery preCheckoutQuery) {
        this.preCheckoutQuery = preCheckoutQuery;
    }

    @JsonProperty("poll")
    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    @JsonProperty("poll_answer")
    public void setPollAnswer(PollAnswer pollAnswer) {
        this.pollAnswer = pollAnswer;
    }

    @JsonProperty("my_chat_member")
    public void setMyChatMember(ChatMemberUpdated myChatMember) {
        this.myChatMember = myChatMember;
    }

    @JsonProperty("chat_member")
    public void setChatMember(ChatMemberUpdated chatMember) {
        this.chatMember = chatMember;
    }

    @JsonProperty("chat_join_request")
    public void setChatJoinRequest(ChatJoinRequest chatJoinRequest) {
        this.chatJoinRequest = chatJoinRequest;
    }

    @JsonProperty("message_reaction")
    public void setMessageReaction(MessageReactionUpdated messageReaction) {
        this.messageReaction = messageReaction;
    }

    @JsonProperty("message_reaction_count")
    public void setMessageReactionCount(MessageReactionCountUpdated messageReactionCount) {
        this.messageReactionCount = messageReactionCount;
    }

    @JsonProperty("chat_boost")
    public void setChatBoost(ChatBoostUpdated chatBoost) {
        this.chatBoost = chatBoost;
    }

    @JsonProperty("removed_chat_boost")
    public void setRemovedChatBoost(ChatBoostRemoved removedChatBoost) {
        this.removedChatBoost = removedChatBoost;
    }

    public String toString() {
        return "Update(updateId=" + this.getUpdateId() + ", message=" + this.getMessage() + ", inlineQuery=" + this.getInlineQuery() + ", chosenInlineQuery=" + this.getChosenInlineQuery() + ", callbackQuery=" + this.getCallbackQuery() + ", editedMessage=" + this.getEditedMessage() + ", channelPost=" + this.getChannelPost() + ", editedChannelPost=" + this.getEditedChannelPost() + ", shippingQuery=" + this.getShippingQuery() + ", preCheckoutQuery=" + this.getPreCheckoutQuery() + ", poll=" + this.getPoll() + ", pollAnswer=" + this.getPollAnswer() + ", myChatMember=" + this.getMyChatMember() + ", chatMember=" + this.getChatMember() + ", chatJoinRequest=" + this.getChatJoinRequest() + ", messageReaction=" + this.getMessageReaction() + ", messageReactionCount=" + this.getMessageReactionCount() + ", chatBoost=" + this.getChatBoost() + ", removedChatBoost=" + this.getRemovedChatBoost() + ")";
    }

    public Update() {
    }

    public Update(Long updateId, Message message, InlineQuery inlineQuery, ChosenInlineQuery chosenInlineQuery, CallbackQuery callbackQuery, Message editedMessage, Message channelPost, Message editedChannelPost, ShippingQuery shippingQuery, PreCheckoutQuery preCheckoutQuery, Poll poll, PollAnswer pollAnswer, ChatMemberUpdated myChatMember, ChatMemberUpdated chatMember, ChatJoinRequest chatJoinRequest, MessageReactionUpdated messageReaction, MessageReactionCountUpdated messageReactionCount, ChatBoostUpdated chatBoost, ChatBoostRemoved removedChatBoost) {
        this.updateId = updateId;
        this.message = message;
        this.inlineQuery = inlineQuery;
        this.chosenInlineQuery = chosenInlineQuery;
        this.callbackQuery = callbackQuery;
        this.editedMessage = editedMessage;
        this.channelPost = channelPost;
        this.editedChannelPost = editedChannelPost;
        this.shippingQuery = shippingQuery;
        this.preCheckoutQuery = preCheckoutQuery;
        this.poll = poll;
        this.pollAnswer = pollAnswer;
        this.myChatMember = myChatMember;
        this.chatMember = chatMember;
        this.chatJoinRequest = chatJoinRequest;
        this.messageReaction = messageReaction;
        this.messageReactionCount = messageReactionCount;
        this.chatBoost = chatBoost;
        this.removedChatBoost = removedChatBoost;
    }
}
