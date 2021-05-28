package com.example.my.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.my.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {

    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_chat, container, false);

        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String,   Object>>();
        for (int i = 0; i <10 ; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", R.mipmap.icon_photo_default);//加入图片
            map.put("ItemName", "用户名");//加入用户名
            listItem.add(map);
        }
        SimpleAdapter adapter=new SimpleAdapter(getActivity(),listItem,R.layout.item_chat_movie,
                new String[]{"ItemImage","ItemName"},new int[]{R.id.imaggViewChat,R.id.tvChat});
        ListView listViewChat=view.findViewById(R.id.lvChat);
        listViewChat.setAdapter(adapter);


        return view;
    }
}
