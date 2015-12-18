package com.cts.sample.tddbdddemo.introscreen;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.cts.sample.tddbdddemo.AndroidResourceDataFetcher;
import com.cts.sample.tddbdddemo.R;
import com.cts.sample.tddbdddemo.collectionmanagement.CollectionModel;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;


public class WelcomeScreenActivity extends FragmentActivity {


    private Gson gson;
    private AndroidResourceDataFetcher androidResourceDataFetcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_old);
        showWelcomeFragment();

        testGSON();


        androidResourceDataFetcher = new AndroidResourceDataFetcher(getBaseContext(), R.raw.content);

        convertJson();

//        SyncServiceHelper.showNotification(this, true);
    }

    private void convertJson() {
        String json = new String(androidResourceDataFetcher.fetch());
        JsonArray jArray = new JsonParser().parse(json).getAsJsonArray();
        ArrayList<CollectionVO> hpCollectionList = new ArrayList<CollectionVO>();

        for (JsonElement obj : jArray) {
            CollectionVO collection = null;
            try {
                collection = gson.fromJson(obj, CollectionVO.class);
            } catch (JsonSyntaxException j) {

            }

            if (null != collection && !collection.status.equalsIgnoreCase("error"))
                hpCollectionList.add(collection);
        }

        for (CollectionVO collectionVO : hpCollectionList) {
            System.out.println(collectionVO);
        }
        System.out.println(hpCollectionList.size());
    }

    private void testGSON() {
        gson = new Gson();
        // convert java object to JSON format,
        // and returned as JSON formatted string
        ArrayList<CollectionModel> models = new ArrayList<>();
        models.add(new CollectionModel(10));
        models.add(new CollectionModel(13));
        models.add(new CollectionModel(14));
        String json = gson.toJson(models);
        System.out.println("JSON::" + json);
    }


    private void showWelcomeFragment() {
        WelcomeFragment welcomeFragment = new WelcomeFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_container, welcomeFragment);
        ft.commit();
    }


}
