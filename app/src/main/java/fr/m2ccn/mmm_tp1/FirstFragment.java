package fr.m2ccn.mmm_tp1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import fr.m2ccn.mmm_tp1.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        setHasOptionsMenu(true); //activer le menu de first fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false );
        View view = binding.getRoot();
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ClientViewModel cvm = new ClientViewModel(new Client());
        binding.setClientViewModel(cvm);

        //button
        Button valider = view.findViewById(R.id.btnValider);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);

                Client c = binding.getClientViewModel().getModel();

                Toast.makeText(getActivity().getApplicationContext(),
                        "/"+c.nom+"/"+c.prenom+"/" + c.villeDeNaissence+"/"+c.numTel, Toast.LENGTH_LONG ).show();
            }
        });
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inf) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inf.inflate(R.menu.menu_first_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.item1) { // if reset
            binding.nom.setText("");
            binding.prenom.setText("");
            binding.villeDeNaissance.setText("");
            binding.numeroDeTelephone.setText("");

            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.item2) { //if tel
            binding.numeroDeTelephone.setVisibility(View.VISIBLE);
            return true;
        }

        if(id == R.id.item3) { //if wiki
            String city = binding.villeDeNaissance.getText().toString();
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://fr.wikipedia.org" + "/wiki/" + city));
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}