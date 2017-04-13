package yyn.com.nytimetodaytop.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import yyn.com.nytimetodaytop.R;
import yyn.com.nytimetodaytop.data.TopsItem;

import java.util.List;

/**
 * Created by jiy on 2017-04-12.
 */
public class TopsListAdapter extends BaseAdapter {
    private Context context = null;
    private List<TopsItem> items = null;

    public TopsListAdapter(Context context, List<TopsItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.tops_list_item,parent,false);

            viewHolder.sectionTextView = (TextView) convertView.findViewById(R.id.tops_list_section);
            viewHolder.titleTextView = (TextView) convertView.findViewById(R.id.tops_list_title);
            viewHolder.absTextView = (TextView) convertView.findViewById(R.id.tops_list_abs);
            viewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.tops_list_thumbnail);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        TopsItem item = items.get(position);

        viewHolder.sectionTextView.setText(item.getSection());
        viewHolder.sectionTextView.setText(item.getTitle());
        viewHolder.sectionTextView.setText(item.getAbs());

        Picasso.with(context)
                .load(item.getImageUrl())
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .resizeDimen(R.dimen.tops_item_image_size, R.dimen.tops_item_image_size)
                .centerInside()
                .tag(context)
                .into(viewHolder.thumbnail);

        return convertView;
    }

    static class ViewHolder{
        TextView sectionTextView;
        TextView titleTextView;
        TextView absTextView;
        ImageView thumbnail;
    }
}
