package com.tedkim.android.tviews.edittext;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.tedkim.android.tviews.R;


/**
 * Created by choebongjae on 2016. 11. 18..
 */

public class MadEditText extends RelativeLayout implements View.OnClickListener {

    private Context mContext;

    private EditText editContent;
    private View editUnderline;
    private SimpleDraweeView imgBtnClear;
    private TextView textStatus;

    public MadEditText(Context context) {
        super(context);
        initEditText(context);
    }

    public MadEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initEditText(context);

    }

    public MadEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initEditText(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MadEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
//-----------underline

    /**
     * 줄 색 바꿈
     *
     * @param colorCode 16진수 컬러코드 ex) #FFFFFF
     * @return MadEditText
     */
    public MadEditText setUnderLineColor(String colorCode) {
        editUnderline.setBackgroundColor(Color.parseColor(colorCode));
        return this;
    }

    //end underline

    //-----------Content

    /**
     * input able editText (ContentText)
     * @return EditText
     */
    public EditText getContentEditText(){
        return editContent;
    }
    public MadEditText setContentText(String text) {
        editContent.setText(text);
        return this;
    }
    public String getContentTextToString(){
        return editContent.getText().toString();
    }

    public MadEditText setContentColor(String colorCode) {
        textStatus.setTextColor(Color.parseColor(colorCode));
        return this;
    }

    public MadEditText setHint(String hint) {
        editContent.setHint(hint);
        return this;
    }

    /**
     * @param typeFaceCode ex) Typeface.BOLD
     * @return MadEditText
     */
    public MadEditText setContentTextStyle(int typeFaceCode) {
        editContent.setTypeface(editContent.getTypeface(), typeFaceCode);
        return this;
    }

    /**
     * 콘텐츠의 텍스트 사이즈를 sp 로결정
     * @param size text sp size
     * @return this
     */
    public MadEditText setContentTextSize(int size) {
        editContent.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        return this;
    }
    //end content

    //-----------Status
    public MadEditText setStatusVisible(boolean statusVisible) {
        textStatus.setVisibility(statusVisible ? View.VISIBLE : View.INVISIBLE);
        return this;
    }

    public MadEditText setStatusText(String text) {
        textStatus.setText(text);
        return this;
    }
    //end status

    //-----------icon btn
    public MadEditText setIconImage(String uri) {
        Uri parseUri = Uri.parse(uri);
        imgBtnClear.setImageURI(parseUri);
        return this;
    }

    private void initEditText(Context context) {
        this.mContext = context;
        if (context == null) {
            throw new NullPointerException("Context is Null");
        }
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_edittext_mad, null);
        addView(view);
        initLayout(view);
    }

    private void initLayout(View view) {
        editContent = (EditText) view.findViewById(R.id.editContent);
        editUnderline = view.findViewById(R.id.viewUnderline);
        imgBtnClear = (SimpleDraweeView) view.findViewById(R.id.imgBtnClear);
        textStatus = (TextView) view.findViewById(R.id.textStatus);

        imgBtnClear.setOnClickListener(this);

        textStatus.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.imgBtnClear) {
            editContent.setText("");
        }
    }
}
