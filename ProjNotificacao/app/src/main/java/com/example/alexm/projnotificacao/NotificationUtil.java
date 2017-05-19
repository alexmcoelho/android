package com.example.alexm.projnotificacao;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import java.io.PipedInputStream;

/**
 * Created by alexm on 4/7/17.
 */

public class NotificationUtil {
    public static final String ACAO_DELETE = "aula.DELETE_NOTIFICACAO";
    public static final String ACAO_NOTIFICACAO = "aula.ACAO_NOTIFICACAO";

    private static PendingIntent criarPendingIntent(Context ctx, String texto, int id){
        Intent resultIntent = new Intent(ctx, DetalheActivity.class);
        resultIntent.putExtra("texto", texto);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(ctx);
        stackBuilder.addParentStack(DetalheActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        return stackBuilder.getPendingIntent(id, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    public static void criarNotificacaoSimples(Context ctx, String texto, int id){
        PendingIntent resultPendingIntent = criarPendingIntent(ctx, texto, id);
        NotificationCompat.Builder nBuilder = new NotificationCompat
                .Builder(ctx)
                .setDefaults(Notification.DEFAULT_ALL)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Simples" +id)
                .setContentText(texto)
                .setContentIntent(resultPendingIntent);
        NotificationManagerCompat nm = NotificationManagerCompat.from(ctx);
        nm.notify(id,nBuilder.build());
    }

    public static void criarNotificacaoCompleto(Context ctx, String texto, int id){
        Uri uriSom = Uri.parse("android.resource://com.example.alexm.ProjNotificacao/" + R.raw.birl);
        PendingIntent pitAcao = PendingIntent.getBroadcast(ctx, 0, new Intent(ACAO_NOTIFICACAO),0);
        PendingIntent pitDelete = PendingIntent.getBroadcast(ctx,0,new Intent(ACAO_DELETE),0);
        Bitmap largeIcon = BitmapFactory.decodeResource(ctx.getResources(),R.mipmap.ic_launcher);
        PendingIntent pitNotificacao = criarPendingIntent(ctx,texto,id);
        NotificationCompat.Builder nBuilder = new NotificationCompat
                .Builder(ctx)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setColor(Color.RED)
                .setContentTitle("Completa" +id)
                .setContentText(texto)
                .setTicker("Chegou uma notificação")
                .setWhen(System.currentTimeMillis())
                .setLargeIcon(largeIcon)
                .setAutoCancel(true)
                .setContentIntent(pitNotificacao)
                .setDeleteIntent(pitDelete)
                .setLights(Color.BLUE, 1000,5000)
                .setSound(uriSom)
                .setVibrate(new long[]{100,500,200,800})
                .addAction(R.mipmap.ic_launcher,"Ação customizada",pitAcao)
                .setNumber(id)
                .setSubText("Subtexto");
        NotificationManagerCompat nm = NotificationManagerCompat.from(ctx);
        nm.notify(id,nBuilder.build());
    }

    public static void criarNotificacaoBig(Context ctx, int idNotificacao){
        int numero = 5;
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("Mensagens não lidas:");
        for (int i = 0; i<=numero; i++){
            inboxStyle.addLine("Mensagem "+i);
        }
        inboxStyle.setSummaryText("Clique para exibir");
        NotificationCompat.Builder nBuilder = new NotificationCompat
                .Builder(ctx)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setColor(Color.RED)
                .setContentTitle("Notificação")
                .setContentText("Varios itens pendentes")
                .setContentIntent(criarPendingIntent(ctx, "Mensagens não lidas",-1))
                .setNumber(numero)
                .setStyle(inboxStyle);

        NotificationManagerCompat nm = NotificationManagerCompat.from(ctx);
        nm.notify(idNotificacao,nBuilder.build());
    }

}

