package bd.com.expresshub.infonetassesment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InfoListAdapter extends RecyclerView.Adapter<InfoListAdapter.ViewHolder> {
    Context context;
    List<UserModel> list;
//    DeleteItemClicklistner deleteItemClicklistner;

    public InfoListAdapter(Context context, List<UserModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.NameTextView.setText(list.get(position).getUserName());
        holder.addressTextView.setText(list.get(position).getCountryName()+", "+list.get(position).getCityName());
        holder.dobTextView.setText(list.get(position).getDob());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView NameTextView, addressTextView, cityTextView, languageTextView, dobTextView;
        ImageView editIV, viewIV, deleteIV;
        public ViewHolder(View itemView) {
            super(itemView);

            NameTextView = itemView.findViewById(R.id.listNameId);
            addressTextView = itemView.findViewById(R.id.listAddressId);
            languageTextView = itemView.findViewById(R.id.listLanguageId);
            dobTextView = itemView.findViewById(R.id.listDobId);
            editIV = itemView.findViewById(R.id.editId);
            viewIV = itemView.findViewById(R.id.viewId);
            deleteIV = itemView.findViewById(R.id.deleteId);

        }
    }
}
