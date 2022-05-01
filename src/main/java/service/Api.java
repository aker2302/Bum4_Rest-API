package service;

import domain.Competition;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Api {

    public String request(String endpoint){

        String result = "";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.football-data.org/v2/" + endpoint)
                .get()
                .addHeader("X-Auth-Token",System.getenv("TOKEN"))
                .build();
        try{
            Response response = client.newCall(request).execute();
            if(response.code() == 200){
                result = response.body().string();
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return result;
    }

    public static List<Competition> setCompetitions(){
        Api api = new Api();
        String body = api.request("competitions");

        Gson gson = new Gson();
        JsonObject jsonObject;

        jsonObject = gson.fromJson(body, JsonObject.class);
        Type competitionListType = new TypeToken<ArrayList<Competition>>(){}.getType();
        List<Competition> competitions = gson.fromJson((jsonObject.get("competitions")), competitionListType);

        return competitions;
    }

}
