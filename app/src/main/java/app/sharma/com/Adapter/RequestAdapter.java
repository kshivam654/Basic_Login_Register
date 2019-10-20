package app.sharma.com.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.sharma.com.R;
import app.sharma.com.ReadRequest;
import app.sharma.com.Request;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.MyHolder> {

    private Context context;
    private ArrayList<ReadRequest> requestAdapters;

    public RequestAdapter(Context c, ArrayList<ReadRequest> l){
        context = c;
        requestAdapters = l;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.leave_layout,viewGroup,false);

        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {


        myHolder.toDate.setText(requestAdapters.get(i).getLeave().getTo().getDate());
        myHolder.toMonth.setText(requestAdapters.get(i).getLeave().getTo().getMonth());
        myHolder.toYear.setText(requestAdapters.get(i).getLeave().getTo().getYear());


        myHolder.fromDate.setText(requestAdapters.get(i).getLeave().getFrom().getDate());
        myHolder.fromMonth.setText(requestAdapters.get(i).getLeave().getFrom().getMonth());
        myHolder.fromYear.setText(requestAdapters.get(i).getLeave().getFrom().getYear());

        myHolder.status.setText(requestAdapters.get(i).getLeave().getRequest());


//        myHolder.toMonth.setText(requestAdapters.get(i).getMonth());
//        myHolder.toYear.setText(requestAdapters.get(i).getYear());

//        myHolder.fromDate.setText(requestAdapters.get(i).getDate());
//        myHolder.fromMonth.setText(requestAdapters.get(i).getMonth());
//        myHolder.fromYear.setText(requestAdapters.get(i).getYear());

        //myHolder.status.setText(requestAdapters.get(i).);
    }

    @Override
    public int getItemCount() {
        return requestAdapters.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView toDate;
        TextView toMonth;
        TextView toYear;

        TextView fromDate;
        TextView fromMonth;
        TextView fromYear;

        TextView status;

        public MyHolder(View itemView) {
            super(itemView);

            toDate= (TextView) itemView.findViewById(R.id.tdate);
            toMonth= (TextView) itemView.findViewById(R.id.tmonth);
            toYear= (TextView) itemView.findViewById(R.id.tyear);

            fromDate= (TextView) itemView.findViewById(R.id.fdate);
            fromMonth= (TextView) itemView.findViewById(R.id.fmonth);
            fromYear= (TextView) itemView.findViewById(R.id.fyear);

            status= (TextView) itemView.findViewById(R.id.status);
        }

        public void onClick(final int position) {
            // on click of any event can be managed here soooo bingo

        }

    }



}
