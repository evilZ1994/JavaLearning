package top.ishavanti.jdbc.service;

import top.ishavanti.jdbc.bean.Message;
import top.ishavanti.jdbc.dao.MessageDAO;

import java.util.Date;
import java.util.List;

/**
 * 消息Service
 */
public class MessageService {

    private MessageDAO messageDAO;

    public MessageService() {
        messageDAO = new MessageDAO();
    }

    /**
     * 分页查询全部留言
     * @param page 当前页码
     * @param pageSize 每页记录数
     * @return 留言列表
     */
    public List<Message> getMessages(int page, int pageSize) {
        return messageDAO.getMessages(page, pageSize);
    }

    /**
     * 计算所有留言数量
     * @return
     */
    public int countMessages() {
        return messageDAO.countMessages();
    }

    /**
     * 保存留言信息
     * @param message
     * @return
     */
    public boolean addMessage(Message message) {
        message.setCreateTime(new Date());
        return messageDAO.addMessage(message);
    }
}
