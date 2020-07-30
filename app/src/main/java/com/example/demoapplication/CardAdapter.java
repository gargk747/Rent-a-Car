package com.example.demoapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>{

    CardData[] cardData;
    Context context;


    public CardAdapter(CardData[] cardData,MainActivity activity) {
        this.cardData=cardData;
        this.context=activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cardview_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CardData cardDataList= cardData[position];
        holder.carName.setText(cardDataList.getCarName());
        holder.carAvailability.setText(cardDataList.getCarAvailability());
        holder.carPetrol.setText(cardDataList.getCarPetrol());
        holder.carImage.setImageResource(cardDataList.getCarImage1());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,cardDataList.getCarName(),Toast.LENGTH_SHORT).show();

                final BottomSheetDialog bottomSheetDialog= new BottomSheetDialog(context,R.style.BottomSheetDialogTheme);
                bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog);
                bottomSheetDialog.setCanceledOnTouchOutside(false);

                TextView carName,carPrice,carPerson,carLocation,carMilage,carColor,carDetails;
                Button book;

                carName= bottomSheetDialog.findViewById(R.id.carName_details);
                carPrice= bottomSheetDialog.findViewById(R.id.carPrice_details);
                carColor= bottomSheetDialog.findViewById(R.id.carColor_details);
                carPerson= bottomSheetDialog.findViewById(R.id.carPerson_details);
                carLocation= bottomSheetDialog.findViewById(R.id.carLocation_details);
                carMilage= bottomSheetDialog.findViewById(R.id.carMilage_details);
                carDetails= bottomSheetDialog.findViewById(R.id.carDetails_details);
                book= bottomSheetDialog.findViewById(R.id.btn_book);

                book.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"Booking Status",Toast.LENGTH_SHORT).show();
                    }
                });
                ImageButton close= (ImageButton)bottomSheetDialog.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });

                carName.setText(cardDataList.getCarName());
                carPrice.setText(cardDataList.getCarPrice());
                carColor.setText(cardDataList.getCarColor());
                carPerson.setText(cardDataList.getCarPerson());
                carLocation.setText(cardDataList.getCarLocation());
                carMilage.setText(cardDataList.getCarMilage());
                carDetails.setText(cardDataList.getCarDetails());

                ImageSlider imageSlider= bottomSheetDialog.findViewById(R.id.slider);

                List<SlideModel> slideModels= new ArrayList<>();

                slideModels.add(new SlideModel(cardDataList.getCarImage1()));
                slideModels.add(new SlideModel(cardDataList.getCarImage2()));
                slideModels.add(new SlideModel(cardDataList.getCarImage3()));
                slideModels.add(new SlideModel(cardDataList.getCarImage4()));
                imageSlider.setImageList(slideModels,false);

                bottomSheetDialog.show();


//                Intent intent= new Intent(context,cardDetails.class);
//                intent.putExtra("CarName",cardDataList.getCarName());
//                intent.putExtra("CarPrice",cardDataList.getCarPrice());
//                intent.putExtra("CarPerson",cardDataList.getCarPerson());
//                intent.putExtra("CarLocation",cardDataList.getCarLocation());
//                intent.putExtra("CarMilage",cardDataList.getCarMilage());
//                intent.putExtra("CarColor",cardDataList.getCarColor());
//                intent.putExtra("CarDetails",cardDataList.getCarDetails());
//                intent.putExtra("CarImage1",cardDataList.getCarImage1());
//                intent.putExtra("CarImage2",cardDataList.getCarImage2());
//                intent.putExtra("CarImage3",cardDataList.getCarImage3());
//                intent.putExtra("CarImage4",cardDataList.getCarImage4());
//                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView carImage;
        TextView carName;
        TextView carAvailability;
        TextView carPetrol;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            carImage = itemView.findViewById(R.id.imageViewCardview);
            carName = itemView.findViewById(R.id.tv_carName);
            carAvailability = itemView.findViewById(R.id.tv_availability);
            carPetrol = itemView.findViewById(R.id.tv_petrol);
        }
    }
}
