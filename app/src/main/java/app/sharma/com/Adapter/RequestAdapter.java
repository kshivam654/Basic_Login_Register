package app.sharma.com.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.sharma.com.Leave;
import app.sharma.com.R;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.MyHolder> {

    private Context context;
    private ArrayList<Leave> requestAdapters;

    public RequestAdapter(Context c, ArrayList<Leave> l){
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


        myHolder.toDate.setText(requestAdapters.get(i).getTo_Date());
        myHolder.toMonth.setText(requestAdapters.get(i).getTo_Month());
        myHolder.toYear.setText(requestAdapters.get(i).getTo_Year());


        myHolder.fromDate.setText(requestAdapters.get(i).getFrom_Date());
        myHolder.fromMonth.setText(requestAdapters.get(i).getFrom_Month());
        myHolder.fromYear.setText(requestAdapters.get(i).getFrom_Year());

        myHolder.status.setText(requestAdapters.get(i).getRequested());


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
