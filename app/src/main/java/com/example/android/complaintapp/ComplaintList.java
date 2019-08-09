package com.example.android.complaintapp;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

/**
 * Created by ritika on 6/3/18.
 */

public class ComplaintList extends ArrayAdapter<Complaint> {
    private View listViewItem;
    private Activity context;
    private DatabaseReference mDatabase;
    private List<Complaint> complaintList;

    /* @Override
     public  boolean areAllItemsEnabled()
     {
         return true;
     }
     @Override
     public boolean isEnabled(int arg0)
     {
         return true;
     }*/
    public ComplaintList(Activity context, List<Complaint> complaintList) {
        super(context, R.layout.list_view, complaintList);
        this.context = context;
        this.complaintList = complaintList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        listViewItem = inflater.inflate(R.layout.list_view, null, true);
        TextView name = (TextView) listViewItem.findViewById(R.id.nameview);
        TextView rollno = (TextView) listViewItem.findViewById((R.id.rollnoview));
        TextView roomno = (TextView) listViewItem.findViewById(R.id.roomnoview);
        TextView number = (TextView) listViewItem.findViewById(R.id.phoneview);
        TextView con = (TextView) listViewItem.findViewById(R.id.conditionview);
        TextView descrip = (TextView) listViewItem.findViewById(R.id.descriptionview);
        TextView service = (TextView) listViewItem.findViewById(R.id.services);

       // EditText resolution = (EditText) listViewItem.findViewById(R.id.resolveview);



        // Button enter=(Button) listViewItem.findViewById(R.id.ResTime);

        Complaint complaint = complaintList.get(position);








        name.setText(complaint.getName());
        rollno.setText(complaint.getRollno());
        String r = complaint.getHostel() + "-" + complaint.getRoomno();
        roomno.setText(r);
        number.setText(complaint.getNumber());
        con.setText(complaint.getCondition());
        descrip.setText(complaint.getDescription());
       String con1 = complaint.getCondition().trim();
        LinearLayout bngcolor = (LinearLayout)listViewItem.findViewById(R.id.listviewstatus);

        if(con1.equals("Emergency"))
        {
            bngcolor.setBackgroundColor(Color.rgb(253,134,134));
        }
        else
        {
            bngcolor.setBackgroundColor(Color.rgb(173,246,146));
        }


        service.setText(complaint.getService());
       // resolution.setText(complaint.getRes());

        return listViewItem;
    }

}







