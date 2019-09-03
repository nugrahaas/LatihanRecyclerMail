package com.example.latihanrecyclermail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MailAdapter extends RecyclerView.Adapter<MailAdapter.ViewHolder> {
    private List<Mail> mailList;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvName, tvSubject, tvContent, tvJam, tvProfName;
        public ImageView ivProfpic;

        public ViewHolder(@NonNull View v) {
            super(v);
            tvProfName = v.findViewById(R.id.tv_prof_name);
            tvName = v.findViewById(R.id.tv_sender_name);
            tvSubject = v.findViewById(R.id.tv_subject);
            tvJam = v.findViewById(R.id.tv_jam);
            tvContent = v.findViewById(R.id.tv_isi_mail);
            ivProfpic = v. findViewById(R.id.iv_profpic);


        }
    }

    public MailAdapter(List<Mail> mailList){
        this.mailList = mailList;

    }

    public MailAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_mail,parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {
        Mail mail = mailList.get(position);
        holder.tvName.setText(String.valueOf(mail.getName()));
        holder.tvSubject.setText(mail.getSubject());
        holder.tvContent.setText(mail.getContent());
        holder.tvJam.setText(mail.getJam());
        holder.tvProfName.setText(mail.getProfName());
        holder.ivProfpic.setImageResource(mail.getPic());

    }

    public int getItemCount(){
        return mailList.size();
    }


}
