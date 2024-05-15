package com.example.dethimobile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolderTodo> {
    private List<TodoModel> list;

    public ToDoAdapter(List<TodoModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolderTodo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo, parent, false);
        return new ViewHolderTodo(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTodo holder, int position) {
        TodoModel todo = list.get(holder.getAdapterPosition());
        holder.id.setText(String.valueOf(list.get(position).getId()));
        holder.description.setText(list.get(position).getTitle());
        holder.completed.setText(String.valueOf(list.get(position).isCompleted()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "User id: " + todo.getUserId(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                new AlertDialog.Builder(view.getContext())
                        .setTitle("xóa todo")
                        .setMessage("có thực sự muốn xóa toodo này không")
                        .setPositiveButton("có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                list.remove(holder.getAdapterPosition());
                                notifyDataSetChanged(); // cập nhật lại danh sách sau khi dxoas
                            }
                        })
                        .setNegativeButton("không", null)
                        .show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolderTodo extends RecyclerView.ViewHolder {
        private TextView id, description, completed;
        public ViewHolderTodo(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.idToDo);
            description = itemView.findViewById(R.id.description);
            completed = itemView.findViewById(R.id.completed);
        }
    }
}
