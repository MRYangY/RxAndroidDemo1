package com.example.yangyu.rxandroiddemo1;

import com.google.gson.Gson;

/**
 * Created by yangyu on 17/8/10.
 */

public class Utils {
    public static Result transform(String data, Class<Result> clas) {
        Result result = null;
        Gson gson = new Gson();
        result = gson.fromJson(data, clas);
        return result;
    }
}
