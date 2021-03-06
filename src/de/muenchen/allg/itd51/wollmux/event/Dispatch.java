/*
 * Dateiname: Dispatch.java
 * Projekt  : WollMux
 * Funktion : Implementiert XDispatch und kann alle Dispatch-URLs behandeln, die kein DocumentModel erfordern.
 * 
 * Copyright (c) 2009-2018 Landeshauptstadt München
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the European Union Public Licence (EUPL), 
 * version 1.0 (or any later version).
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * European Union Public Licence for more details.
 *
 * You should have received a copy of the European Union Public Licence
 * along with this program. If not, see 
 * http://ec.europa.eu/idabc/en/document/7330
 *
 * Änderungshistorie:
 * Datum      | Wer | Änderungsgrund
 * -------------------------------------------------------------------
 * 05.11.2009 | BNK | Erstellung
 * -------------------------------------------------------------------
 *
 * @author Matthias Benkmann (D-III-ITD-D101)
 * 
 */
package de.muenchen.allg.itd51.wollmux.event;

import java.util.Vector;

import com.sun.star.beans.PropertyValue;

/**
 * Implementiert XDispatch und kann alle Dispatch-URLs behandeln, die kein
 * DocumentModel erfordern. Nähere Infos zur Funktionsweise siehe
 * {@link BaseDispatch}.
 * 
 * @author Matthias Benkmann (D-III-ITD-D101)
 */
public class Dispatch extends BaseDispatch
{
  public static final String DISP_unoPrint = ".uno:Print";

  public static final String DISP_unoPrintDefault = ".uno:PrintDefault";

  public static final String DISP_unoPrinterSetup = ".uno:PrinterSetup";

  public static final String DISP_wmAbsenderAuswaehlen =
    "wollmux:AbsenderAuswaehlen";

  public static final String DISP_wmPALVerwalten = "wollmux:PALVerwalten";

  public static final String DISP_wmOpenTemplate = "wollmux:OpenTemplate";

  public static final String DISP_wmOpen = "wollmux:Open";

  public static final String DISP_wmOpenDocument = "wollmux:OpenDocument";

  public static final String DISP_wmKill = "wollmux:Kill";

  public static final String DISP_wmAbout = "wollmux:About";

  public static final String DISP_wmDumpInfo = "wollmux:DumpInfo";

  public static final String DISP_wmFunctionDialog = "wollmux:FunctionDialog";

  public static final String DISP_wmFormularMax4000 = "wollmux:FormularMax4000";

  public static final String DISP_wmZifferEinfuegen = "wollmux:ZifferEinfuegen";

  public static final String DISP_wmAbdruck = "wollmux:Abdruck";

  public static final String DISP_wmZuleitungszeile = "wollmux:Zuleitungszeile";

  public static final String DISP_wmMarkBlock = "wollmux:MarkBlock";

  public static final String DISP_wmTextbausteinEinfuegen =
    "wollmux:TextbausteinEinfuegen";

  public static final String DISP_wmPlatzhalterAnspringen =
    "wollmux:PlatzhalterAnspringen";

  public static final String DISP_wmTextbausteinVerweisEinfuegen =
    "wollmux:TextbausteinVerweisEinfuegen";

  public static final String DISP_wmSeriendruck = "wollmux:Seriendruck";

  public static final String DISP_wmTest = "wollmux:Test";

  public static final String DISP_wmPrintPage = "wollmux:PrintPage";

  /**
   * Enthält alle aktuell registrierten StatusListener Grund für Auskommentierung:
   * Braucht doch keiner, oder?
   */
  // protected final Vector<XStatusListener> statusListener =
  // new Vector<XStatusListener>();
  public void dispatch_wollmux_absenderauswaehlen(String arg, PropertyValue[] props)
  {
    WollMuxEventHandler.handleShowDialogAbsenderAuswaehlen();
  }

  public void dispatch_wollmux_palverwalten(String arg, PropertyValue[] props)
  {
    WollMuxEventHandler.handleShowDialogPersoenlicheAbsenderliste();
  }

  public void dispatch_wollmux_opentemplate(String arg, PropertyValue[] props)
  {
    Vector<String> fragIds = new Vector<String>();
    String[] parts = arg.split("&");
    for (int i = 0; i < parts.length; i++)
      fragIds.add(parts[i]);
    WollMuxEventHandler.handleOpenDocument(fragIds, true);
  }

  public void dispatch_wollmux_open(String arg, PropertyValue[] props)
  {
    WollMuxEventHandler.handleOpen(arg);
  }

  public void dispatch_wollmux_opendocument(String arg, PropertyValue[] props)
  {
    Vector<String> fragIds = new Vector<String>();
    String[] parts = arg.split("&");
    for (int i = 0; i < parts.length; i++)
      fragIds.add(parts[i]);
    WollMuxEventHandler.handleOpenDocument(fragIds, false);
  }

  public void dispatch_wollmux_kill(String arg, PropertyValue[] props)
  {
    WollMuxEventHandler.handleKill();
  }

  public void dispatch_wollmux_about(String arg, PropertyValue[] props)
  {
    String wollMuxBarVersion = null;
    if (arg.length() > 0) wollMuxBarVersion = arg;
    WollMuxEventHandler.handleAbout(wollMuxBarVersion);
  }

  public void dispatch_wollmux_dumpinfo(String arg, PropertyValue[] props)
  {
    WollMuxEventHandler.handleDumpInfo();
  }
  
  // zur Vermeidung java.lang.NoSuchMethodException:
  // de.muenchen.allg.itd51.wollmux.event.Dispatch.status_wollmux_dumpinfo()
  public boolean status_wollmux_dumpinfo()
  {    
    return true;
  }

  // zur Vermeidung java.lang.NoSuchMethodException:
  // de.muenchen.allg.itd51.wollmux.event.Dispatch.status_wollmux_about()
  public boolean status_wollmux_about()
  {
    return true;
  }
}
