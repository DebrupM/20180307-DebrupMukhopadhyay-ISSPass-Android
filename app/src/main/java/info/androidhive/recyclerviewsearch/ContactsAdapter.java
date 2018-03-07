package info.androidhive.recyclerviewsearch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ravi on 16/11/17.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {
    private Context context;
    private List<PassResponse> contactList;
    private ContactsAdapterListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, phone;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            phone = view.findViewById(R.id.phone);
        }
    }


    public ContactsAdapter(Context context, List<PassResponse> contactList, ContactsAdapterListener listener) {
        this.context = context;
        this.listener = listener;
        this.contactList = contactList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_row_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final PassResponse passResponse = contactList.get(position);
        holder.name.setText(passResponse.getFormattedRiseTime().toString());
        holder.phone.setText(passResponse.getDuration());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }


    public interface ContactsAdapterListener {
        void onContactSelected(Contact contact);
    }
}
