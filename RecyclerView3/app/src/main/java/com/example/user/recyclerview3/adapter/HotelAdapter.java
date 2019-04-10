package com.example.user.recyclerview3.adapter;


import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.user.recyclerview3.R;
import com.example.user.recyclerview3.model.Hotel;
import java.util.ArrayList;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {
    ArrayList<Hotel> hotelList;
    IHotelAdapter mIHoteklAdapter;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position)
    {
        Hotel hotel = hotelList.get(position);
        holder.tvJudul.setText(hotel.judul);
        holder.ivFoto.setImageURI(Uri.parse(hotel.foto));
    }

    @Override
    public int getItemCount() {
        if (hotelList != null)
            return hotelList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivFoto;
        TextView tvJudul, tvDeskripsi;
        Button bEdit, bDelete;
        ImageButton ibFav, ibShare;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);
            bEdit = (Button) itemView.findViewById(R.id.buttonEdit);
            bDelete = (Button) itemView.findViewById(R.id.buttonDelete);
            ibFav = (ImageButton) itemView.findViewById(R.id.buttonFavorite);
            ibShare = (ImageButton) itemView.findViewById(R.id.buttonShare);


            itemView.setOnClickListener(new View.OnClickListener() { @Override
            public void onClick(View v) { mIHoteklAdapter.doClick(getAdapterPosition()); }
            });
            bEdit.setOnClickListener(new View.OnClickListener() { @Override
            public void onClick(View v) { mIHoteklAdapter.doEdit(getAdapterPosition());
            }
            });
            bDelete.setOnClickListener(new View.OnClickListener() { @Override
            public void onClick(View v) { mIHoteklAdapter.doDelete(getAdapterPosition());
            }
            });
            ibFav.setOnClickListener(new View.OnClickListener() { @Override
            public void onClick(View v) { mIHoteklAdapter.doFav(getAdapterPosition());
            }
            });
            ibShare.setOnClickListener(new View.OnClickListener() { @Override
            public void onClick(View v) {
                mIHoteklAdapter.doShare(getAdapterPosition());
            }
            });
        }

    }



    public HotelAdapter(Context context, ArrayList<Hotel> hotelList)
    {
        this.hotelList = hotelList;
        mIHoteklAdapter = (IHotelAdapter) context;
    }

    public interface IHotelAdapter{
        void doClick(int pos);
        void doEdit(int pos);
        void doDelete(int pos);
        void doFav(int pos);
        void doShare(int pos);

    }




}
