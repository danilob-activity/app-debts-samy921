package com.example.danilo.appdebts.Adapters;



import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.danilo.appdebts.Classes.Debts;
import com.example.danilo.appdebts.R;

import java.util.List;

/**
 * Created by aluno on 03/07/19.
 */

public class DebtsAdapter extends RecyclerView.Adapter<DebtsAdapter.ViewHolderDebts> {
        private List<Debts> mData;
        public DebtsAdapter(List<Debts> data) {
            mData = data;
        }
        @NonNull
        @Override
        public DebtsAdapter.ViewHolderDebts onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.list_view_debts, parent, false);
            ViewHolderDebts holderDebts = new ViewHolderDebts(view);
            return holderDebts;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolderDebts holder, int position) {
            if (mData != null && mData.size() > 0) {
                Debts debt = mData.get(position);
                holder.mDescription.setText(debt.getDescription());
            }
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        public class ViewHolderDebts extends RecyclerView.ViewHolder {
            public TextView mDescription;
            public ViewHolderDebts(View itemView) {
                super(itemView);
                mDescription = (TextView) itemView.findViewById(R.id.textViewDescription);
            }
        }
}
