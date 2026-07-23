package com.example.trynewthingsinandroid.home

import androidx.lifecycle.ViewModel
import com.example.trynewthingsinandroid.data.ImageUIState

class HomeScreenViewModel : ViewModel() {
    
    /**
     * Returns a list of real image URLs for the wallpaper gallery.
     */
    fun getImageList(): List<ImageUIState> {
        return listOf(
            ImageUIState("https://images.unsplash.com/photo-1446776811953-b23d57bd21aa?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1501785888041-af3ef285b470?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1470770841072-f978cf4d019e?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1433086966358-54859d0ed716?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1500382017468-9049fed747ef?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1472214103451-9374bd1c798e?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1441974231531-c6227db76b6e?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1532274402911-5a3b04759bb2?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1506744038136-46273834b3fb?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1469474968028-56623f02e42e?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1447752875215-b2761acb3c5d?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1446776811953-b23d57bd21aa?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1501785888041-af3ef285b470?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1470770841072-f978cf4d019e?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1433086966358-54859d0ed716?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1500382017468-9049fed747ef?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1472214103451-9374bd1c798e?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1441974231531-c6227db76b6e?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1532274402911-5a3b04759bb2?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1506744038136-46273834b3fb?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1469474968028-56623f02e42e?q=80&w=1000&auto=format&fit=crop"),
            ImageUIState("https://images.unsplash.com/photo-1447752875215-b2761acb3c5d?q=80&w=1000&auto=format&fit=crop")
        )
    }
}
