package co.edu.eci.ieti.android.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import co.edu.eci.ieti.R;
import co.edu.eci.ieti.android.network.model.Task;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ViewHolder>{
    List<Task> taskList = null;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType )
    {
        return new ViewHolder( LayoutInflater.from( parent.getContext() ).inflate( R.layout.task_row, parent, false ) );
    }

    @Override
    public void onBindViewHolder( @NonNull ViewHolder holder, int position )
    {
        Task task = taskList.get( position );
        //TODO implement update view holder using the task values
        ((TextView) holder.itemView.findViewById(R.id.id)).setText((int) task.getId());
        ((TextView) holder.itemView.findViewById(R.id.description)).setText(task.getDescription());
        ((TextView) holder.itemView.findViewById(R.id.priority)).setText("Priority: "+ task.getPriority());
        ((TextView) holder.itemView.findViewById(R.id.date)).setText("Date: "+ task.getDueDate());
    }

    @Override
    public int getItemCount()
    {
        return taskList != null ? taskList.size() : 0;
    }

    public TasksAdapter(List<Task> tasks) {
        this.taskList = tasks;
    }

    public void updateTasks(List<Task> tasks){
        this.taskList = tasks;
        notifyDataSetChanged();
    }

    class ViewHolder
            extends RecyclerView.ViewHolder
    {
        ViewHolder( @NonNull View itemView )
        {
            super( itemView );
        }
    }
}
