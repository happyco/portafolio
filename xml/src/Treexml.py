import xml.etree.ElementTree as ET
import xml.dom.minidom

dest = 'out.xml'

def writeXML(ifr):
    impl = xml.dom.minidom.getDOMImplementation()
    doc = impl.createDocument(None,'menu',None)
    
    root = doc.documentElement
    
    for el in ifr:
        writeElement(el, root,  doc)
    
    import codecs
    #f = open(dest, "w")
    f = codecs.open(dest, "w", "utf-8")
    doc.writexml(f, encoding="UTF-8", indent="\t", newl="\n",addindent="\t")


def writeElement(el, parent, doc):

    item = doc.createElement(el.tag)
    

    item.setAttribute("id", str(el.attrib['id']))
    
    item.setAttribute("prompt", el.attrib['prompt'])
    
    if el.tag == "oneof":
        for option in el:
            optag = doc.createElement("option")
            optag.setAttribute("text", str(option.attrib['name']))
            optag.setAttribute("value", str(option.attrib['value']))
            item.appendChild(optag)
        

    parent.appendChild(item)
    
    for child in el:
        if not child.tag == 'option':
            writeElement(child, item,  doc)


def depthsearch(root, id, tree):
    print id
    for child in root:
        if child.attrib['id'] == id and child.tag == 'form':
                
            xmlchild = ET.SubElement(tree, child.tag, child.attrib)
            
            for child2 in child:
                if child2.tag == 'goto':
                    depthsearch(root, child2.attrib['id'], xmlchild)
                elif child2.tag == 'oneof':
                    xmloneof = ET.SubElement(xmlchild, child2.tag, child2.attrib)
                    for option in child2:
                        ET.SubElement(xmloneof, option.tag, option.attrib)
                else:
                    ET.SubElement(xmlchild, child2.tag, child.attrib)
                 
    return tree

treexml = ET.parse('test.xml')
root = treexml.getroot()

roottree = ET.Element('menu')
    
roottree=depthsearch(root,root[0].attrib['id'],roottree)

writeXML(roottree)