package microservices.project.target.service;

import microservices.project.target.entity.Notification;
import microservices.project.target.mapper.NotificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NotificationService implements NotificationService {

    private final NotificationMapper notificationMapper;

    @Autowired
    public NotificationService(NotificationMapper notificationMapper) {
        this.notificationMapper = notificationMapper;
    }

    @Override
    public Notification createNotification(Notification notification) {
        notificationMapper.insert(notification);
        return notification; // The notification object will now contain the generated ID
    }

    @Override
    public Notification getNotificationById(Integer notificationId) {
        return notificationMapper.selectById(notificationId);
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationMapper.selectAll();
    }

    @Override
    public void updateNotification(Notification notification) {
        notificationMapper.updateById(notification);
    }

    @Override
    public void deleteNotification(Integer notificationId) {
        notificationMapper.deleteById(notificationId);
    }
}
