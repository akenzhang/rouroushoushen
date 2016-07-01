package akenzhang.rouroushoushen.discovery.adatper;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import akenzhang.rouroushoushen.R;

/**
 * Created by Administrator on 2016/6/30 0030.
 */
public class FocusInnerData extends RecyclerView.ViewHolder {
    private ImageView userImage,userLv,focusImg;
    private TextView username,data,contentText,action,greaded,speaded;

    public ImageView getUserImage() {
        return userImage;
    }

    public void setUserImage(ImageView userImage) {
        this.userImage = userImage;
    }

    public ImageView getUserLv() {
        return userLv;
    }

    public void setUserLv(ImageView userLv) {
        this.userLv = userLv;
    }

    public ImageView getFocusImg() {
        return focusImg;
    }

    public void setFocusImg(ImageView focusImg) {
        this.focusImg = focusImg;
    }

    public TextView getUsername() {
        return username;
    }

    public void setUsername(TextView username) {
        this.username = username;
    }

    public TextView getData() {
        return data;
    }

    public void setData(TextView data) {
        this.data = data;
    }

    public TextView getContentText() {
        return contentText;
    }

    public void setContentText(TextView contentText) {
        this.contentText = contentText;
    }

    public TextView getAction() {
        return action;
    }

    public void setAction(TextView action) {
        this.action = action;
    }

    public TextView getGreaded() {
        return greaded;
    }

    public void setGreaded(TextView greaded) {
        this.greaded = greaded;
    }

    public TextView getSpeaded() {
        return speaded;
    }

    public void setSpeaded(TextView speaded) {
        this.speaded = speaded;
    }

    public FocusInnerData(View itemView) {
        super(itemView);
        userImage = (ImageView) itemView.findViewById(R.id.focus_userimg);
        userLv = (ImageView) itemView.findViewById(R.id.focus_userlv);
        focusImg= (ImageView) itemView.findViewById(R.id.focus_img);
        username = (TextView) itemView.findViewById(R.id.focus_username);
        data= (TextView) itemView.findViewById(R.id.focus_date);
        contentText = (TextView) itemView.findViewById(R.id.focus_content_text);
        action = (TextView) itemView.findViewById(R.id.focus_action);
        greaded = (TextView) itemView.findViewById(R.id.focus_greaded);
        speaded = (TextView) itemView.findViewById(R.id.focus_speak);


    }
}
