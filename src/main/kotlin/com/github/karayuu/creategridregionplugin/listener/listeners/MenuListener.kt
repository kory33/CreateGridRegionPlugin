package com.github.karayuu.creategridregionplugin.listener.listeners

import com.github.karayuu.creategridregionplugin.menu.MenuSession
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryEvent
import org.bukkit.event.inventory.InventoryOpenEvent

/**
 * Created by karayuu on 2017/12/25
 * Developer of Gigantic☆Seichi Server
 * Support at dev-basic or dev-extreme channel of Discord
 */
class MenuListener : Listener {
    private fun InventoryEvent.getMenuSession() = inventory?.holder as? MenuSession

    @EventHandler
    fun onMenuClick(event: InventoryClickEvent) {
        val menuIssuer = event.getMenuSession() ?: return

        menuIssuer.getBoundAction(event.slot).invoke(event)

        event.isCancelled = true
    }

    @EventHandler
    fun onMenuClose(event: InventoryCloseEvent) = event.getMenuSession()?.onMenuClose(event)

    @EventHandler
    fun onMenuOpen(event: InventoryOpenEvent) = event.getMenuSession()?.onMenuOpen(event)

}
