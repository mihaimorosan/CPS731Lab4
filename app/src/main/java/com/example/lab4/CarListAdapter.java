package com.example.lab4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.CarViewHolder>
{
    private String[] mCarTitle = {
            "BMW M3 E46",
            "Nissan Skyline R34 GTR",
            "Chevrolet Camaro Z28",
            "Lamborghini Aventador S",
            "Shelby Cobra 427",
            "Aston Martin DB5",
            "Mazda RX-7 FD",
            "Honda S2000",
            "Toyota Supra MK4",
            "Mercedes-Benz G63 AMG"
    };

    private String[] carText = {
            "The E46 M3 is powered by the BMW S54 inline-six engine with either a 6-speed manual or a 6-speed SMG-II automated manual transmission. The M3 was introduced in late 2000 and was produced in coupe and convertible body styles only.",
            "The GF-BNR34 (R34) Nissan Skyline GT-R, GT-R V·Spec and GT-R V·Spec N1 models were introduced in January 1999. The R34 GT-R was shorter (from front to rear), and the front overhang was reduced as compared to its predecessor. The valve covers were painted glossy red (colour code Cherry Red Effect Z24 or X1020), as opposed to black in previous models.",
            "The Chevrolet Camaro is a mid-size American automobile manufactured by Chevrolet, classified as a pony car and some versions also as a muscle car. It went on sale on September 29, 1966, for the 1967 model year and was designed as a competing model to the Ford Mustang.",
            "The Lamborghini Aventador S is a mid-engine sports car produced by the Italian automotive manufacturer Lamborghini. In keeping with Lamborghini tradition, the Aventador is named after a fighting bull.",
            "The AC Cobra, sold in the United States as the Shelby Cobra and AC Shelby Cobra, is a British-American sports car with a Ford V8 engine, produced intermittently in both the UK and the US since 1962.",
            "The Aston Martin DB5 is a British luxury grand tourer that was made by Aston Martin and designed by the Italian coachbuilder Carrozzeria Touring Superleggera. Released in 1963, it was an evolution of the final series of DB4. Although not the first in the DB series, the DB5 is the best-known cinematic James Bond car, first appearing in the James Bond film Goldfinger.",
            "The Mazda RX-7 is a front/mid-engine, rear-wheel-drive, rotary engine-powered sports car that was manufactured and marketed by Mazda from 1978 to 2002 across three generations, all of which made use of a compact, lightweight Wankel rotary engine.",
            "The Honda S2000 is an open top sports car that was manufactured by Japanese automobile manufacturer Honda, from 1999 to 2009. First shown as a concept car at the Tokyo Motor Show in 1995, the production version was launched on April 15, 1999 to celebrate the company's 50th anniversary.",
            "The Toyota Supra is a sports car and grand tourer manufactured by Toyota Motor Corporation beginning in 1978. The initial four generations of the Supra were produced from 1978 to 2002.",
            "The AMG G 63 is a legend raised to a higher power for a new era. Advanced luxury, unwavering confidence, and seemingly endless individualization let you create a G that's at ease in any corner of the world."
    };

    private final LayoutInflater inflater;
    private final Context c;

    public CarListAdapter(Context c) {
        this.inflater = LayoutInflater.from(c);
        this.c = c;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.carlist_item,parent,false);
        return new CarViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        holder.carTitle.setText(mCarTitle[position]);
        holder.carText.setText(carText[position]);
    }

    @Override
    public int getItemCount() { return carText.length; }

    class CarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public final TextView carTitle;
        public final TextView carText;
        public final CardView cardView;
        final CarListAdapter adapter;
        public CarViewHolder(@NonNull View itemView, CarListAdapter adapter) {
            super(itemView);
            this.carTitle = itemView.findViewById(R.id.title);
            this.carText = itemView.findViewById(R.id.text);
            this.cardView = itemView.findViewById(R.id.cardview);
            this.adapter = adapter;
            this.cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            String car = mCarTitle[position];
            Intent intent = new Intent(view.getContext(), CarDetails.class);
            intent.putExtra("position",""+position);
            intent.putExtra("car",car);
            view.getContext().startActivity(intent);
        }
    }
}
