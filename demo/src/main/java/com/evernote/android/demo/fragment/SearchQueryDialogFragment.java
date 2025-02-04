package com.evernote.android.demo.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;


import com.evernote.android.demo.fragment.note.NoteContainerFragment;
import com.evernote.demo.R;
import com.google.android.material.textfield.TextInputLayout;

/**
 * @author rwondratschek
 */
public class SearchQueryDialogFragment extends DialogFragment {

    public static final String TAG = "SearchQueryDialogFragment";

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_create_note, null);
        final TextInputLayout titleView = (TextInputLayout) view.findViewById(R.id.textInputLayout_title);
        titleView.setHint(getString(R.string.query));

        view.findViewById(R.id.textInputLayout_content).setVisibility(View.GONE);

        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        if (getParentFragment() instanceof NoteContainerFragment) {
                            ((NoteContainerFragment) getParentFragment()).search(titleView.getEditText().getText().toString());
                        } else {
                            throw new IllegalStateException();
                        }
                        break;
                }
            }
        };

        return new AlertDialog.Builder(requireActivity())
                .setTitle(R.string.search)
                .setView(view)
                .setPositiveButton(android.R.string.ok, onClickListener)
                .setNegativeButton(android.R.string.cancel, onClickListener)
                .create();
    }
}
