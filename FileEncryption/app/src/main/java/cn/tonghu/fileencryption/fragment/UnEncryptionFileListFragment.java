package cn.tonghu.fileencryption.fragment;

import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.io.File;

import cn.tonghu.fileencryption.R;
import cn.tonghu.fileencryption.utils.EncryptUtils;

/**
 * Created by tonghu on 2/5/15.
 */
public class UnEncryptionFileListFragment extends FileListFragment {
    @Override
    protected int getType() {
        return TYPE_UNENCRYPTION;
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.menu_unencryption, menu);
        mode.setTitle("Selction Items");
        setSubtitle(mode);
        return true;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.unencryption:
                //TODO encrypt files
                SparseBooleanArray choicePositions = getListView().getCheckedItemPositions();
                for (int i = 0; i < getListView().getCount(); i++) {
                    if (choicePositions.get(i)) {
                        EncryptUtils.unEncrypt((File) getListView().getItemAtPosition(i));
                    }
                }
                mode.finish();
                notifyData();
                break;
        }
        return true;
    }
}
