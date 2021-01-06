package com.mit_muzaffarpur.Home;


import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.mit_muzaffarpur.R;

import java.util.Objects;

/**
 * MyMessagingService used to show push notifications [FCM] : TOPIC - general
 */
@Keep
public class MyMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        showNotification(Objects.requireNonNull(remoteMessage.getNotification()).getTitle(),
                remoteMessage.getNotification().getBody());

    }


    public void showNotification(String title, String message) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,
                "MyNotifications").setContentTitle(title).setSmallIcon(R.drawable.mit_pic).setAutoCancel(true).setContentText(message);

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(999, builder.build());

    }
}