package app.sharma.com.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.sharma.com.Leave;
import app.sharma.com.R;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.MyHolder> {

    private Context context;
    private ArrayList<Leave> requestAdapters;

    public RequestAdapter(Context c, ArrayList<Leave> l) {
        context = c;
        requestAdapters = l;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.leave_layout, viewGroup, false);

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


        switch (requestAdapters.get(i).getRequested()) {
            case "0":
                myHolder.status.setText("Reqest Pending");
                myHolder.ll.setBackgroundColor(Color.parseColor("#FFC107"));
                break;
            case "1":
                myHolder.status.setText("Reqest Visited");
                myHolder.ll.setBackgroundColor(Color.parseColor("#929290"));
                break;
            case "2":
                myHolder.status.setText("Reqest Accepted");
                myHolder.ll.setBackgroundColor(Color.parseColor("#0FEB18"));
                break;
            case "3":
                myHolder.status.setText("Reqest Denied");
                myHolder.ll.setBackgroundColor(Color.parseColor("#EC1010"));
                break;

        }

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

        LinearLayout ll;

        public MyHolder(View itemView) {
            super(itemView);

            toDate = itemView.findViewById(R.id.tdate);
            toMonth = itemView.findViewById(R.id.tmonth);
            toYear = itemView.findViewById(R.id.tyear);

            fromDate = itemView.findViewById(R.id.fdate);
            fromMonth = itemView.findViewById(R.id.fmonth);
            fromYear = itemView.findViewById(R.id.fyear);

            status = itemView.findViewById(R.id.status);

            ll = itemView.findViewById(R.id.ll);
        }

        public void onClick(final int position) {
            // on click of any event can be managed here soooo bingo

        }

    }


}
