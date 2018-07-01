package com.example.android.journalapp;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.example.android.journalapp.data.JournalContract.JournalAppEntry;

    /**
     * {@link JournalCursorAdapter} is an adapter for a list or grid view
     * that uses a {@link Cursor} of journalApp data as its data source. This adapter knows
     * how to create list items for each row of journalApp data in the {@link Cursor}.
     */
    public class JournalCursorAdapter extends CursorAdapter {

        /**
         * Constructs a new {@link JournalCursorAdapter}.
         *
         * @param context The context
         * @param c       The cursor from which to get the data.
         */
        public JournalCursorAdapter(Context context, Cursor c) {
            super(context, c, 0 /* flags */);
        }

        /**
         * Makes a new blank list item view. No data is set (or bound) to the views yet.
         *
         * @param context app context
         * @param cursor  The cursor from which to get the data. The cursor is already
         *                moved to the correct position.
         * @param parent  The parent to which the new view is attached to
         * @return the newly created list item view.
         */
        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            // Inflate a list item view using the layout specified in list_item.xml
            return LayoutInflater.from(context).inflate(R.layout.journal_display, parent, false);
        }

        /**
         * This method binds the journalApp data (in the current row pointed to by cursor) to the given
         * list item layout. For example, the name for the current journalApp can be set on the name TextView
         * in the list item layout.
         *
         * @param view    Existing view, returned earlier by newView() method
         * @param context app context
         * @param cursor  The cursor from which to get the data. The cursor is already moved to the
         *                correct row.
         */
        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            // Find individual views that we want to modify in the list item layout
            TextView nameTextView = (TextView) view.findViewById(R.id.Journal_Title);
            TextView summaryTextView = (TextView) view.findViewById(R.id.Journal_Body);

            // Find the columns of journalApp attributes that we're interested in
            int titleColumnIndex = cursor.getColumnIndex(JournalAppEntry.COLUMN_JOURNAL_TITLE);
            int bodyColumnIndex = cursor.getColumnIndex(JournalAppEntry.COLUMN_JOURNAL_BODY);

            // Read the journalApp attributes from the Cursor for the current journalApp
            String journalTitle = cursor.getString(titleColumnIndex);
            String journalBody = cursor.getString(bodyColumnIndex);

            // If the journalApp breed is empty string or null, then use some default text
            // that says "Unknown breed", so the TextView isn't blank.
            if (TextUtils.isEmpty(journalBody)) {
                journalBody = context.getString(R.string.empty_journal);
            }

            // Update the TextViews with the attributes for the current journalApp
            nameTextView.setText(journalTitle);
            summaryTextView.setText(journalBody);
        }
    }

//}
