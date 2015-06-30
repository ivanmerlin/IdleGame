package com.ivan.game.idlegame;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.ivan.game.idlegame.com.ivan.game.idlegame.model.AdventurePlace;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AdventureFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AdventureFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdventureFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AdventureFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AdventureFragment newInstance(String param1, String param2) {
        AdventureFragment fragment = new AdventureFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public AdventureFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_adventure, container, false);
        ListView lv=(ListView)v.findViewById(R.id.locationList);
        ArrayList<AdventurePlace> list=new ArrayList<AdventurePlace>();
        AdventurePlace ap1=new AdventurePlace("郊外森林");
        ap1.setDescription("城市郊外的小森林，很多冒险者在这里经过");
        AdventurePlace ap2=new AdventurePlace("遥远山谷");
        ap2.setDescription("离城市已经有一段距离，凶猛的野兽在这里出没");
        AdventurePlace ap3=new AdventurePlace("黑暗洞穴");
        ap3.setDescription("山谷里的小洞穴，常常传出巨大的吼叫声，被怀疑是大黑熊的巢穴");

        list.add(ap1);
        list.add(ap2);
        list.add(ap3);
        lv.setAdapter(new MyAdapter(list));
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    //管理List每一行Item
    class MyAdapter extends BaseAdapter{

        ArrayList<AdventurePlace> placeList;
        LayoutInflater layoutInflater;
        public MyAdapter(ArrayList<AdventurePlace> placeList){
            this.placeList=placeList;
            layoutInflater=LayoutInflater.from(getActivity());
        }


        //xiongbabadefanyilun
        @Override
        public int getCount() {

            return placeList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //lalalademaxiya
            //lalalalademaxiya

            ViewHolder vh=null;
            if(convertView==null){
                convertView=layoutInflater.inflate(R.layout.item_adventure,null);
                vh=new ViewHolder();
                vh.b=(Button)convertView.findViewById(R.id.goButtonImage);
                vh.tv1=(TextView)convertView.findViewById(R.id.placeId);
                vh.tv2=(TextView)convertView.findViewById(R.id.placeDescription);
                vh.iv1=(ImageView)convertView.findViewById(R.id.placeImage);
                convertView.setTag(vh);  //view -- 绑定--convertview
            }else{
                vh=(ViewHolder)convertView.getTag();
            }
//完成了控件的定位
            //开始填数据
            vh.tv1.setText(placeList.get(position).getName());
            vh.tv2.setText(placeList.get(position).getDescription());
            //！！！！！还需要添加图片和按钮
            return convertView;


        }
    }

    class ViewHolder{
        TextView tv1;
        TextView tv2;
        ImageView iv1;
        Button b;
    }
}
