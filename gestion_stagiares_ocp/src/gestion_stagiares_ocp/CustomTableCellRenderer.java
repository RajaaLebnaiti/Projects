package gestion_stagiares_ocp;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

class CustomTableCellRenderer extends DefaultTableCellRenderer {
	 private DefaultTableModel tableModel;

	    public CustomTableCellRenderer(DefaultTableModel tableModel) {
	        this.tableModel = tableModel;
	    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Vérifier si la valeur de la colonne "Absence" est supérieure à 4
        if (column == tableModel.findColumn("Absence")) {
            String absenceValue = (String) value;
            try {
                int absenceInt = Integer.parseInt(absenceValue);
                if (absenceInt > 4) {
                    cellComponent.setForeground(Color.RED);
                } else {
                    cellComponent.setForeground(table.getForeground());
                }
            } catch (NumberFormatException e) {
                // Gérer le cas où la valeur de la colonne "Absence" n'est pas un entier valide
                cellComponent.setForeground(table.getForeground());
            }
        } else {
            cellComponent.setForeground(table.getForeground());
        }

        return cellComponent;
    }
}
