package net.melove.demo.OO.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hyphenate.chat.EMClient;

import net.melove.demo.OO.ChatActivity;
import net.melove.demo.OO.R;

public class ChatFragment extends Fragment {
    // 发起聊天 username 输入框
    private EditText mChatIdEdit;
    // 发起聊天
    private Button mStartChatBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_chat, null);
        initView(view);
        return view;



    }
    private void initView(View view) {

        mChatIdEdit = view.findViewById(R.id.ec_edit_chat_id);

        mStartChatBtn = view.findViewById(R.id.ec_btn_start_chat);
        mStartChatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取我们发起聊天的者的username
                String chatId = mChatIdEdit.getText().toString().trim();
                if (!TextUtils.isEmpty(chatId)) {
                    // 获取当前登录用户的 username
                    String currUsername = EMClient.getInstance().getCurrentUser();
                    if (chatId.equals(currUsername)) {
                        Toast.makeText(getActivity(), "不能和自己聊天", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    // 跳转到聊天界面，开始聊天
                    Intent intent = new Intent(getActivity() ,ChatActivity.class);
                    intent.putExtra("ec_chat_id", chatId);
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), "Username 不能为空", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
