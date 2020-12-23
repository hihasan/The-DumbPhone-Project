package com.dumbphone.dumbphone.utils;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.dumbphone.dumbphone.R;
import com.dumbphone.dumbphone.views.MainActivity;


public class BaseActivity extends AppCompatActivity {
    //base of all activity class
    public static DialogUtil dialogUtil;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initialize dialog utils class for getting dialog util object
        dialogUtil = new DialogUtil(this);
    }

    public static void showToast(Context ctx, String msg) {
        Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(String msg){
        Toast.makeText(DumbApplication.getAppContext(), msg, Toast.LENGTH_SHORT);
    }

    public static void showWait(String msg, Context context){
        dialogUtil = new DialogUtil(context);
        dialogUtil.showProgressDialog(msg);
    }

    public static void hideWait(){
        if(dialogUtil == null) return;
        dialogUtil.dismissProgress();
    }

    public static void showError(Object err){
        hideWait();
        if(err instanceof Exception){
            Exception exception = (Exception) err;
            showToast(DumbApplication.getAppContext(), exception.getMessage());
        }
        else if(err instanceof String){
            showToast(DumbApplication.getAppContext(), err.toString());
        }
        else{
            showToast(DumbApplication.getAppContext(),"An error occurred");
        }
    }

    //method for network available or not checking
    public static boolean isNetworkAvailable() {

        ConnectivityManager connectivityManager
                = (ConnectivityManager) DumbApplication.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }


    //method for fragment calling

    protected void initFragment(Fragment fragment, String id, int resId) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(resId, fragment, id)
                .addToBackStack(null)
                .commit();
    }

    //method for fragment replace
    protected void replaceFragment(Fragment fragment, String id, int resId) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(resId, fragment, id)
                .addToBackStack(id)
                .commit();
    }



    //method for show error message form Api
    //No plan to implement right now
//    public <T> void showErrorMessage(int responseCode, Response<T> response) {
//        try {
//            JSONObject jsonObject;
//            try {
//                jsonObject = new JSONObject(response.errorBody().string());
//                String errorMessage = jsonObject.getString("error");
//                Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }


    //method for going to homepage
    public void gotoHomePage() {

        Intent intent;
        intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);

    }

//    public void loadFragment(Fragment fragment) {
//        // load fragment
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.fragment_container, fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }
}
