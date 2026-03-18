package com.atakmap.android.helloworld.plugin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BloodhoundOrderAdapter extends RecyclerView.Adapter<BloodhoundOrderAdapter.OrderViewHolder> {
    public interface OnDeleteClickListener {
        void onDelete(BloodhoundOrder order);
    }
    private final List<BloodhoundOrder> orders;
    private final OnDeleteClickListener deleteClickListener;
    public BloodhoundOrderAdapter(List<BloodhoundOrder> orders, OnDeleteClickListener deleteClickListener) {
        this.orders = orders;
        this.deleteClickListener = deleteClickListener;
    }
    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.bloodhound_order_row, parent, false);
        return new OrderViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        BloodhoundOrder order = orders.get(position);
        holder.title.setText(order.getMapItemTitle());
        holder.contact.setText(order.getContact());
        holder.status.setText(order.getStatus().name());
        holder.deleteBtn.setOnClickListener(v -> deleteClickListener.onDelete(order));
    }
    @Override
    public int getItemCount() {
        return orders.size();
    }
    static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView title, contact, status;
        Button deleteBtn;
        OrderViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.orderTitle);
            contact = v.findViewById(R.id.orderContact);
            status = v.findViewById(R.id.orderStatus);
            deleteBtn = v.findViewById(R.id.deleteOrderBtn);
        }
    }
}

