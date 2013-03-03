# GridActivity

GridActivity is super class of activity using grid view.
This class is similar to ListActivity.


## Usage

### add activity_layout.xml In your layout.folder

      <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
          xmlns:tools="http://schemas.android.com/tools"
          android:layout_width="match_parent"
          android:layout_height="match_parent" >

          <GridView
              android:id="@+id/grid"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              android:layout_centerInParent="true" >
          </GridView>

          <TextView
              android:id="@+id/empty"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:layout_centerInParent="true" />
      
      </RelativeLayout> 


And extends GridActivity.

This class use is similar to ListActivity.
