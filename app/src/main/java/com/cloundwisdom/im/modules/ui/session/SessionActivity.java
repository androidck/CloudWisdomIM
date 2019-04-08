package com.cloundwisdom.im.modules.ui.session;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.cloundwisdom.im.R;
import com.cloundwisdom.im.common.base.BasePresenter;
import com.cloundwisdom.im.common.base.MyActivity;
import com.hjq.bar.TitleBar;
import com.lqr.emoji.EmotionKeyboard;
import com.lqr.emoji.EmotionLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 聊天界面
 */
public class SessionActivity extends MyActivity {


    @BindView(R.id.view_title)
    TitleBar viewTitle;
    @BindView(R.id.rvMsg)
    RecyclerView rvMsg;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.ivAudio)
    ImageView ivAudio;
    @BindView(R.id.etContent)
    EditText etContent;
    @BindView(R.id.btnAudio)
    Button btnAudio;
    @BindView(R.id.ivEmo)
    ImageView ivEmo;
    @BindView(R.id.ivMore)
    ImageView ivMore;
    @BindView(R.id.btnSend)
    Button btnSend;
    @BindView(R.id.llContent)
    AutoLinearLayout llContent;
    @BindView(R.id.elEmotion)
    EmotionLayout elEmotion;
    @BindView(R.id.flEmotionView)
    AutoFrameLayout flEmotionView;
    @BindView(R.id.llRoot)
    AutoLinearLayout llRoot;
    private int isVoiceContent;//切换文字或语音
    private int ivEmoType;//表情开关 0 为开启 1 开启

    private EmotionKeyboard mEmotionKeyboard;


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_session;
    }

    @Override
    protected int getTitleBarId() {
        return R.id.view_title;
    }

    @Override
    protected void initView() {
        elEmotion.attachEditText(etContent);
        initEmotionKeyboard();
    }


    @Override
    protected void initData() {

    }

    private void initEmotionKeyboard() {
        mEmotionKeyboard = EmotionKeyboard.with(this);
        mEmotionKeyboard.bindToEditText(etContent);
        mEmotionKeyboard.bindToContent(llContent);
        mEmotionKeyboard.setEmotionLayout(elEmotion);
        mEmotionKeyboard.bindToEmotionButton(ivEmo, ivMore);

    }


    @OnClick({R.id.ivAudio, R.id.btnAudio, R.id.ivEmo, R.id.ivMore})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivAudio://切换语音，
                voiceContentSwitch();
                break;
            case R.id.btnAudio://按住说话
                break;
            case R.id.ivEmo://打开表情布局
                emoSwitch();
                break;
            case R.id.ivMore://打开更多功能
                break;
        }
    }

    /**
     * 语音文字切换
     */
    private void voiceContentSwitch() {
        if (isVoiceContent == 0) {
            //切换为语音
            isVoiceContent = 1;
            etContent.setVisibility(View.GONE);
            btnAudio.setVisibility(View.VISIBLE);
        } else if (isVoiceContent == 1) {
            //切换为文字
            isVoiceContent = 0;
            etContent.setVisibility(View.VISIBLE);
            btnAudio.setVisibility(View.GONE);
        }
        //当类型不为 0 的时候影藏表情界面
        if (ivEmoType != 0) {
            flEmotionView.setVisibility(View.GONE);
            elEmotion.setVisibility(View.GONE);
        }
    }

    /**
     * 表情切换
     */
    private void emoSwitch() {
        if (ivEmoType == 0) {
            ivEmoType = 1;
            flEmotionView.setVisibility(View.VISIBLE);
            elEmotion.setVisibility(View.VISIBLE);
            if (isVoiceContent != 0) {
                //切换为文字
                isVoiceContent = 0;
                etContent.setVisibility(View.VISIBLE);
                btnAudio.setVisibility(View.GONE);
            }
        } else if (ivEmoType == 1) {
            ivEmoType = 0;
            flEmotionView.setVisibility(View.GONE);
            elEmotion.setVisibility(View.GONE);
        }
    }

  
}
