package com.example.ayush.widgetapplication;

import android.app.PendingIntent;
import android.app.SearchManager;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {

    String link = "https://acadgild.com/";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.new_app_widget);
            //creating intent for opening website
            Intent openweb = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
            //pending intent for the same
            PendingIntent pendingIntent1 = PendingIntent.getActivity(context,2,openweb,0);
            //on click listener for the button
            remoteViews.setOnClickPendingIntent(R.id.bt_openWebsite,pendingIntent1);
            //updating app widget
            appWidgetManager.updateAppWidget(appWidgetIds,remoteViews);
        }

    }
}

