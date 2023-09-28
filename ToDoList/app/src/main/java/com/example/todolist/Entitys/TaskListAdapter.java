package com.example.todolist.Entitys;

import android.content.Context;
import android.view.*;
import android.widget.*;

import androidx.annotation.*;

import com.example.todolist.R;

import java.util.List;

public class TaskListAdapter extends ArrayAdapter<Task> {

    public TaskListAdapter(Context context, int resource, List<Task> tasks) {
        super(context, resource, tasks);
    }

    @NonNull
//    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View itemView = inflater.inflate(R.layout.activity_list_item, parent, false);

        Task task = getItem(position);

        CheckBox checkbox = itemView.findViewById(R.id.cbxTask);
        TextView titleTextView = itemView.findViewById(R.id.txtTask);

        checkbox.setChecked(task.isCompleted());
        titleTextView.setText(task.getTitle());

        return itemView;
    }
}